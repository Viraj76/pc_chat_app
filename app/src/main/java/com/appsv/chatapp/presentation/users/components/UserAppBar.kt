package com.appsv.chatapp.presentation.users.components



import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.chatapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAppBar(
    title : String
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.Blue
                    ,
                    fontSize = 25.sp,
                ),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.blue)
        ),
//        navigationIcon = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.outline_mode_edit_outline_24),
//                    contentDescription = null,
//                    tint = Color(0xFFCCCCCC)
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    imageVector = Icons.Outlined.Search,
//                    contentDescription = null,
//                    tint = Color(0xFFCCCCCC)
//                )
//            }
//        },
    )
}