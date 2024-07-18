package com.appsv.chatapp.presentation.users


import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsv.chatapp.domain.models.Users
import com.appsv.chatapp.presentation.users.components.UserAppBar
import com.appsv.chatapp.presentation.users.components.UserItem


@Composable
fun UsersScreen(
    modifier: Modifier = Modifier,
    event: (UsersEvent) -> Unit,
    state: UsersState,
    onClick : (String) -> Unit
) {

    LaunchedEffect(Unit) {
        event(UsersEvent.FetchUsersList)
    }

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        UserAppBar("Users")

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize(),
        ) {
            items(state.usersList) { user ->
                UserItem(
                    users = user,
                    onClick = {
                        onClick(user._id.toString())
                    }
                )
            }
        }
    }
}

val listtt = listOf(
    Users(username = "Virat"),
    Users(username = "Rohit")
)