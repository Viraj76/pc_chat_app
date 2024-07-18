package com.appsv.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.appsv.chatapp.presentation.navigation.SetUpNavGraph
import com.appsv.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.dark(
                Color(0xFF5DB5FB).toArgb(),     // res color as int
            )
        )
        installSplashScreen()
        setContent {
            ChatAppTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.blue)))
                {
                    SetUpNavGraph()

                }
            }
        }
    }
}
