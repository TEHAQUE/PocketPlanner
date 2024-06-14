package com.example.pocketplaner.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketplaner.R
import com.example.pocketplaner.ui.theme.NotiEl
import com.example.pocketplaner.ui.theme.getFakeNoti
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun NotifPage(){
    
    val notiList = getFakeNoti()
//    Text(text = notiList.toString())
    
    Column(
        modifier = Modifier
//            .fillMaxSize()
            .background(Color(0xFF9477D8))
            .padding(start = 8.dp, top = 25.dp, end = 8.dp, bottom = 110.dp)
    ){
        LazyColumn(
            content = {
                itemsIndexed(notiList) { index: Int, item: NotiEl ->
                    NotiElItem(item = item)
                }
            }
        )
    }
}

@Composable
fun NotiElItem(item: NotiEl){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFD0BCFF)),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        )
        {
            Text(text = SimpleDateFormat("HH:mm, dd.mm.yyyy", Locale.UK).format(item.date),
                fontSize = 15.sp,
                color = Color(0xFF464646)
                )
            Text(text = item.title,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.baseline_hide_source_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}