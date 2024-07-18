package com.appsv.chatapp.domain.repository

import com.appsv.chatapp.domain.models.Message
import com.appsv.chatapp.domain.models.Users
import kotlinx.coroutines.flow.Flow

interface ChatsRepository {

    suspend fun addUser(users: Users) : Flow<Int>
    suspend fun fetchUsers() : Flow<List<Users>>
    suspend fun sendMessage(message: Message)
    suspend fun getMessages(chatRoomId : String) : Flow<List<Message>>
}