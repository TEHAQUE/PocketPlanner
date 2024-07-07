package com.example.pocketplaner.comps

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketplaner.NotiViewModel
import java.time.Instant
import java.util.Date
import java.util.concurrent.atomic.AtomicInteger

data class Notification(val message: String, val timestamp: Date)

@Composable
fun NotifPage(modifier: Modifier = Modifier, viewModel: NotiViewModel) {
    val notifications = mutableStateListOf<Notification>()

    fun addNotification(notification: Notification) {
        notifications.add(notification)
    }

    viewModel.addNotiResult.observeAsState().value?.let { result ->
        addNotification(Notification("Add Transaction Result: $result", Date.from(Instant.now())))
    }

    viewModel.deleteNotiResult.observeAsState().value?.let { result ->
        addNotification(Notification("Delete Result: $result", Date.from(Instant.now())))
    }

    viewModel.setUserResult.observeAsState().value?.let { result ->
        addNotification(Notification("Set User Result: $result", Date.from(Instant.now())))
    }

    viewModel.setUserSalResult.observeAsState().value?.let { result ->
        addNotification(Notification("Set User Salary Result: $result", Date.from(Instant.now())))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9477D8))
            .padding(start = 8.dp, top = 25.dp, end = 8.dp, bottom = 110.dp),
    ) {
        notifications.forEach { notification ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF815BD8))
                    .padding(8.dp),
            ) {
                Text(
                    text = "${notification.timestamp}",
                    fontSize = 18.sp,
                    color = Color.White
                )
                Text(
                    text = "${notification.message}",
                    fontSize = 22.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = modifier.height(10.dp))
        }
    }
}

//@Composable
//fun NotiElItem(item: NotiEl){
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clip(RoundedCornerShape(6.dp))
//            .background(Color(0xFFD0BCFF)),
//        verticalAlignment = Alignment.CenterVertically
//    )
//    {
//        Column(
//            modifier = Modifier
//                .padding(8.dp)
//                .weight(1f)
//        )
//        {
//            Text(text = SimpleDateFormat("HH:mm, dd.mm.yyyy", Locale.UK).format(item.date),
//                fontSize = 15.sp,
//                color = Color(0xFF464646)
//            )
//            Text(text = item.title,
//                fontSize = 20.sp,
//                color = Color.White
//            )
//        }
//        IconButton(onClick = {}) {
//            Icon(painter = painterResource(id = R.drawable.baseline_hide_source_24),
//                contentDescription = "Delete",
//                tint = Color.White
//            )
//        }
//    }
//}