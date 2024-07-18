package com.appsv.chatapp.presentation.chat

import com.appsv.chatapp.domain.models.Message

data class ChatStates (
    val messageList : List<Message> = emptyList()
)