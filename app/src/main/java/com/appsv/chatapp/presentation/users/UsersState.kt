package com.appsv.chatapp.presentation.users

import com.appsv.chatapp.domain.models.Users

data class UsersState(
    val usersList : List<Users> = emptyList()
)