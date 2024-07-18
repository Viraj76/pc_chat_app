package com.appsv.chatapp.data.repository

import android.util.Log
import com.appsv.chatapp.data.remote.ChatApi
import com.appsv.chatapp.domain.models.Message
import com.appsv.chatapp.domain.models.Users
import com.appsv.chatapp.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatsRepositoryImpl(
    val chatApi: ChatApi
) : ChatsRepository {
    override suspend fun addUser(users: Users): Flow<Int> = flow{
        emit(chatApi.addUsers(users).code())
    }

    override suspend fun fetchUsers(): Flow<List<Users>> = flow {
        emit(chatApi.fetchUsers().body()!!)
    }

    override suspend fun sendMessage(message: Message) {
        chatApi.sendMessage(message)
    }

    override suspend fun getMessages(chatRoomId: String): Flow<List<Message>> = flow{
        try {
            emit(chatApi.getMessages(chatRoomId).body()!!)

        }
        catch (e : Exception){
            Log.d("Exception" , e.message.toString())
        }
    }
}