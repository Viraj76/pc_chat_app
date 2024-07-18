package com.appsv.chatapp.presentation.add_user

sealed class AddUserEvent {

    data class AddUser(val userName : String) : AddUserEvent()
}