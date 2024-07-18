package com.appsv.chatapp.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.chatapp.domain.models.Users
import com.appsv.chatapp.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UsersViewModel  : ViewModel() , KoinComponent{
    private val chatsRepository : ChatsRepository by inject()

    private val _state = MutableStateFlow(UsersState())
    val state = _state

    fun onEvent(event : UsersEvent){
        when(event){
            UsersEvent.FetchUsersList -> {
                viewModelScope.launch { chatsRepository.fetchUsers().collect {usersList->

                    _state.value = state.value.copy(usersList = usersList)

                }}
            }
        }
    }
}