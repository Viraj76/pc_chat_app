package com.appsv.chatapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.appsv.chatapp.presentation.add_user.AddUserViewModel
import com.appsv.chatapp.presentation.add_user.AddUsersScreen
import com.appsv.chatapp.presentation.chat.ChatScreen
import com.appsv.chatapp.presentation.chat.ChatViewModel
import com.appsv.chatapp.presentation.users.UsersScreen
import com.appsv.chatapp.presentation.users.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetUpNavGraph(modifier: Modifier = Modifier) {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AddUserScreen){

        composable<AddUserScreen> {
            val viewModel : AddUserViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            AddUsersScreen(
                state = state,
                event =  viewModel::onEvent,
                navController = navController
            )
        }

        composable<UsersScreen> {
            val viewModel : UsersViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            UsersScreen(
                event = viewModel::onEvent,
                state =  state
            ){receiverId->

                navController.navigate(ChatsScreen(
                    receiverId = receiverId,
                    senderId = "669824b7cdaeefd40360182c"
                ))
            }
        }

        composable<ChatsScreen> {
            val args = it.toRoute<ChatsScreen>()
            val viewModel : ChatViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            LaunchedEffect (Unit){
                viewModel.getMessages(createChatRoomId(args.senderId,args.receiverId))
            }
            ChatScreen(navController = navController,
                senderId = args.senderId, receiverId = args.receiverId ,
                events = viewModel::onEvent,
                states = state)
        }


    }
}

fun createChatRoomId(id1: String, id2: String): String {
    val ids = listOf(id1, id2).sorted()
    return ids.joinToString(separator = "_")
}

