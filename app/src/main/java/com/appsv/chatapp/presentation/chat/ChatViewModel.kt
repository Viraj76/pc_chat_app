package com.appsv.chatapp.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.chatapp.SocketHandler
import com.appsv.chatapp.domain.models.Message
import com.appsv.chatapp.domain.repository.ChatsRepository
import com.google.gson.Gson
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChatViewModel : ViewModel() , KoinComponent {
    private val chatsRepository : ChatsRepository by inject()

    private var socket : Socket = IO.socket("http://192.168.100.102:3000/")

    init {
        socket.connect()


        socket.on("newMessage"){

            it?.let {arrayData->

                val messageJson = arrayData[0]

                val message = Gson().fromJson(messageJson.toString() , Message::class.java)

                val newMessageList = state.value.messageList.toMutableList()

                newMessageList.add(message)

                _state.value =state.value.copy(messageList = newMessageList)



            }

        }
    }

    private val _state = MutableStateFlow(ChatStates())
    val state = _state

    fun onEvent(events: ChatsEvents){
        when(events){
            is ChatsEvents.SendMessage -> {
                viewModelScope.launch {
                    chatsRepository.sendMessage(events.message)
                }
            }
        }
    }

    fun getMessages(chatRoomID : String){
        viewModelScope.launch {
            chatsRepository.getMessages(chatRoomID).collect{
                _state.value = state.value.copy(messageList = it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        socket.disconnect()
        socket.off()
    }
}
