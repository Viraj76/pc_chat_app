package com.appsv.chatapp.presentation.chat

import com.appsv.chatapp.domain.models.Message

sealed class ChatsEvents {
    data class SendMessage(val message: Message) : ChatsEvents()
}