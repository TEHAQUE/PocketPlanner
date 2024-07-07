package com.example.pocketplaner.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pocketplaner.NotiViewModel

@Composable
fun Settings(modifier: Modifier = Modifier, viewModel: NotiViewModel) {
    var name by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF381D77))
            .padding(start = 8.dp, top = 25.dp, end = 8.dp, bottom = 10.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name",
                fontSize = 20.sp,
                color = Color.White)
            },
            textStyle = TextStyle(color = Color.White, fontSize = 21.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp)
        )

        OutlinedTextField(
            value = balance,
            onValueChange = { balance = it },
            label = { Text("Enter your balance",
                fontSize = 20.sp,
                color = Color.White)
            },
            textStyle = TextStyle(color = Color.White, fontSize = 21.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp)
        )

        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text("Enter your salary",
                fontSize = 20.sp,
                color = Color.White)
            },
            textStyle = TextStyle(color = Color.White, fontSize = 21.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp)
        )

        Button(
            onClick = {
                val balanceFloat = balance.toFloatOrNull() ?: 0f
                val salaryDouble = salary.toFloatOrNull() ?: 0f
                viewModel.setUser(name, balanceFloat)
                viewModel.setUserSal(salaryDouble)
                name = ""
                balance = ""
                salary = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text("Submit")
        }
    }
}