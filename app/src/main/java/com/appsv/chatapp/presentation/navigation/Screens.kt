package com.appsv.chatapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Serializable
data object AddUserScreen

@Serializable
data object UsersScreen

@Serializable
data class ChatsScreen(
    val senderId : String,
    val receiverId : String
)