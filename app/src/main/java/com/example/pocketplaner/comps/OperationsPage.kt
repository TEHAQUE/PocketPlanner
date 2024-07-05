package com.example.pocketplaner.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketplaner.NotiViewModel
import com.example.pocketplaner.R
import com.example.pocketplaner.ui.theme.NotiEl
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun OperationsPage(modifier: Modifier = Modifier, viewModel: NotiViewModel) {

    val notiList by viewModel.notiList.observeAsState(emptyList())
    var nameVal by remember {
        mutableStateOf("")
    }
    var costVal by remember {
        mutableStateOf("")
    }
    fun convertToFloat(value: String): Float {
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            0F
        }
    }
    val floatValue = convertToFloat(costVal)
    Column(
        modifier = Modifier
            .background(Color(0xFF9477D8))
            .padding(start = 8.dp, top = 25.dp, end = 8.dp, bottom = 110.dp)
    ) {
        Text(
            text = "Add monthly payout:",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 12.dp)
                    .border(2.dp, Color(0xFF381D77), RoundedCornerShape(8.dp)),
                value = nameVal,
                onValueChange = { nameVal = it },
                placeholder = {
                    Text(
                        "Payout name",
                        style = TextStyle(color = Color.White, fontSize = 21.sp)
                    )
                },
                textStyle = TextStyle(color = Color.White, fontSize = 21.sp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .border(2.dp, Color(0xFF381D77), RoundedCornerShape(8.dp)),
                value = costVal,
                onValueChange = { costVal = it },
                placeholder = {
                    Text(
                        "Price",
                        style = TextStyle(color = Color.White, fontSize = 21.sp)
                    )
                }
            )
        }
        Button(
            onClick = {
                viewModel.addNoti(nameVal, floatValue)
                nameVal = ""
                costVal = ""
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            Text(text = "Add")
        }
        Text(
            text = "Your payouts:",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            content = {
                itemsIndexed(notiList) { index: Int, item: NotiEl ->
                    NotiListItem(item = item, onDelete = { viewModel.deleteNoti(item.id) })
                }
            }
        )
    }
}

@Composable
fun NotiListItem(item: NotiEl, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFD0BCFF)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm, dd.MM.yyyy", Locale.UK).format(item.date),
                fontSize = 15.sp,
                color = Color(0xFF464646)
            )
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        IconButton(onClick = { onDelete() }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_hide_source_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}
