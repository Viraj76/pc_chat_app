package com.appsv.chatapp.presentation.di

import com.appsv.chatapp.presentation.add_user.AddUserViewModel
import com.appsv.chatapp.presentation.chat.ChatViewModel
import com.appsv.chatapp.presentation.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { AddUserViewModel() }
    viewModel { UsersViewModel() }
    viewModel { ChatViewModel() }
}