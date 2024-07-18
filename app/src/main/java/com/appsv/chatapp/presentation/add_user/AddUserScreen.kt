package com.appsv.chatapp.presentation.add_user

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.appsv.chatapp.R
import com.appsv.chatapp.presentation.navigation.UsersScreen


@Composable
fun AddUsersScreen(
    modifier: Modifier = Modifier,
    state: AddUserState,
    event :   (AddUserEvent) -> Unit,
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val textState = remember { mutableStateOf("") }

        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text("Enter name") },
            placeholder = { Text("Enter your name here..") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Blue,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Blue,
                focusedPlaceholderColor = Color.Blue,
                unfocusedPlaceholderColor = Color.Blue,
                unfocusedLabelColor = Color.Blue,
                focusedLabelColor = Color.Blue,
                cursorColor = Color.Blue
            )
        )

        Button(
            onClick ={
            event(AddUserEvent.AddUser(textState.value))
        }
        )
        {
            Text(text = "Add User")
        }

        Button(onClick ={
            navController.navigate(UsersScreen)
        } ) {
            Text(text = "Just Go")
        }

        LaunchedEffect(key1 = state) {
            if(state.addedUser){
                navController.navigate(UsersScreen)
            }
        }
    }
}


