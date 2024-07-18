package com.appsv.chatapp.presentation.chat.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.chatapp.domain.models.Message
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@Preview
@Composable
private fun Prev() {

    MessageBox(message = Message(
        message = "hello",
        senderId = "adafafasdf",
        receiverId = "adfaeav",
        timestamp = "23:23"
    ))
    
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MessageBox(
    message: Message,
) {
    val modifier = if ("669824b7cdaeefd40360182c" == message.senderId) {
        Modifier
            .padding(start = 16.dp, end = 8.dp)
            .defaultMinSize(minHeight = 60.dp)
            .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomStart = 20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF007EF4),
                        Color(0xFF2A75BC),
                    )
                )
            )
    } else {
        Modifier
            .padding(start = 8.dp, end = 16.dp)
            .defaultMinSize(minHeight = 60.dp)
            .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomEnd = 20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF454545),
                        Color(0xFF2B2B2B),
                    )
                )
            )
    }

    val boxArrangement = if ("669824b7cdaeefd40360182c" == message.senderId) Alignment.CenterEnd else Alignment.CenterStart

    Box(modifier = Modifier
        .padding(vertical = 12.dp)
        .fillMaxWidth(), contentAlignment = boxArrangement) {
        Row(
            verticalAlignment = Alignment.Bottom,
        ) {


            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = message.message,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = formatTimestampToHHMM(message.timestamp!!),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                        )
                    )
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun formatTimestampToHHMM(timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(timestamp, formatter)

    // Convert to IST (Indian Standard Time) which is UTC+5:30
    val zoneId = ZoneId.of("Asia/Kolkata")
    val istDateTime = zonedDateTime.withZoneSameInstant(zoneId)

    // Format hours and minutes
    val hours = istDateTime.hour.toString().padStart(2, '0')
    val minutes = istDateTime.minute.toString().padStart(2, '0')

    return "$hours:$minutes"
}