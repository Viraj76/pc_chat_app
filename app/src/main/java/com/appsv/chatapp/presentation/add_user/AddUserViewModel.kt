package com.appsv.chatapp.presentation.add_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.chatapp.domain.models.Users
import com.appsv.chatapp.domain.repository.ChatsRepository
import com.appsv.chatapp.presentation.navigation.AddUserScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddUserViewModel : ViewModel() , KoinComponent {

    val chatsRepository : ChatsRepository by inject()

    private val _state = MutableStateFlow(AddUserState())
    val state  = _state

    fun onEvent(event : AddUserEvent){
        when(event){
            is AddUserEvent.AddUser -> {
                val username = event.userName
                viewModelScope.launch {
                    addUser(username)
                }
            }
        }
    }

    private suspend fun addUser(username: String) {
        val users = Users(username = username)

        chatsRepository.addUser(users).collect{status ->

            if(status == 201){
                _state.value = state.value.copy(addedUser = true)
            }
            else{
                _state.value = state.value.copy(addedUser = false)
            }
        }
    }


}