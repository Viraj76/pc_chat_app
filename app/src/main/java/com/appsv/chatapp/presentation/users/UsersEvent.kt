package com.appsv.chatapp.presentation.users

sealed class UsersEvent {
    data object FetchUsersList : UsersEvent()
}