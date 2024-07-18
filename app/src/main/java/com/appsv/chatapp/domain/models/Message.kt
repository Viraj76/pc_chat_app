package com.appsv.chatapp.domain.models

data class Message(
    val message: String,
    val senderId: String,
    val receiverId: String,
    val timestamp: String? = null
)

val messageList = listOf(
    Message(
        message = "how are you",
        senderId = "adafafasdf",
        receiverId = "adfaeav",
        timestamp = "23:23"
    ),
    Message(
        message = "everything fine ?",
        senderId = "adafafasdf",
        receiverId = "adfaeav",
        timestamp = "23:23"
    ),
    Message(
        message = "hello",
        senderId = "adafafasdf",
        receiverId = "adfaeav",
        timestamp = "23:23"
    ),
    Message(
        message = "Hiii",
        senderId = "adafafasdf",
        receiverId = "adfaeav",
        timestamp = "23:23"
    ),


)