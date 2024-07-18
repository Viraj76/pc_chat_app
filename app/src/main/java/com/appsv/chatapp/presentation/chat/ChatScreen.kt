package com.appsv.chatapp.presentation.chat


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.appsv.chatapp.R
import com.appsv.chatapp.domain.models.Message
import com.appsv.chatapp.domain.models.messageList
import com.appsv.chatapp.presentation.chat.component.MessageBox
import com.appsv.chatapp.presentation.chat.component.MessageInputField
import com.appsv.chatapp.presentation.users.components.UserAppBar


//@Preview
//@Composable
//private fun Pree() {
//    ChatScreen(navController = rememberNavController(), senderId = "dfsdfsdf", receiverId = "sdfasdfad")
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    senderId: String,
    receiverId: String,
    events: (ChatsEvents) -> Unit,
    states: ChatStates
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()

    ) {


        UserAppBar("Chats")

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            reverseLayout = false,
        ) {
            items(states.messageList) { message ->
                MessageBox(
                    message = message
                )
            }
        }

        MessageInputField(
        ) {message->
            val message = Message(
                message = message,
                senderId = senderId,
                receiverId = receiverId
            )
            events(ChatsEvents.SendMessage(message))
        }
    }
}

/*
rId  == "adfadfa"   Rohit
sId  == "dfadfadf"    Virat

chatRoomId  == rId + sId (sort)
 */

