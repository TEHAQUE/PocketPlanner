package com.example.pocketplaner.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketplaner.NotiViewModel

data class SavingsModel(
    val name: String,
    val f: Double,
    val b: Double,
    val s: Double,
    val description: String,
    val gradientColors: List<Color>
)

val balance = 123412.12
val salaryAP = 4125.21
val expensesAP = 3024.32
@Composable
fun DashBoard(modifier: Modifier = Modifier, viewModel: NotiViewModel) {
    val totalCostState: State<Float?> = viewModel.getTotalCost().observeAsState(initial = null)
    val userName: State<String?> = viewModel.getUserName().observeAsState("")
    val userBalance: State<Float?> = viewModel.getUserBalance().observeAsState(0f)
    val userSalary: State<Float?> = viewModel.getUserSalary().observeAsState(0f)
    val sumExState: State<Float?> = viewModel.getSumEx().observeAsState(initial = null)
    val sumLsState: State<Float?> = viewModel.getSumLs().observeAsState(initial = null)
    val sumSaState: State<Float?> = viewModel.getSumSa().observeAsState(initial = null)
    val savingsModels = listOf(
        SavingsModel(
            name = "50/30/20",
            b = 0.50,
            f = 0.30,
            s = 0.20,
            description = "Save 50% on essentials, 30% on lifestyle, and 20% on savings.",
            gradientColors = listOf(Color(0xFF815BD8), Color(0xFF2B0B75))
        ),
        SavingsModel(
            name = "80/20",
            b = 0.80,
            f = 0.0,
            s = 0.20,
            description = "Spend 80% on necessities and save 20%.",
            gradientColors = listOf(Color(0xFFE7A1FE), Color(0xFF4B0082))
        ),
        SavingsModel(
            name = "70/20/10",
            b = 0.70,
            f = 0.20,
            s = 0.10,
            description = "Allocate 70% for living expenses, 20% for savings, and 10% for investments.",
            gradientColors = listOf(Color(0xFF7FFFD4), Color(0xFF00CED1))
        ),
        SavingsModel(
            name = "60/20/20",
            b = 0.60,
            f = 0.20,
            s = 0.20,
            description = "Use 60% for essentials, 20% for lifestyle, and 20% for savings.",
            gradientColors = listOf(Color(0xFFFFD700), Color(0xFFFF6347))
        )
    )

    val (selectedModel, setSelectedModel) = remember { mutableStateOf(savingsModels[0]) }

    LazyColumn {
        item{
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color(0xFF815BD8), Color(0xFF2B0B75))
                                )
                            )
                            .padding(start = 8.dp, top = 25.dp, end = 8.dp, bottom = 110.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF4F3A7E))
                                .padding(8.dp)
                        ) {
                            userName.value?.let { name ->
                                Text(
                                    text = "Welcome back, $name",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                            }?: run {
                                Text(
                                    text = "nobady",
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            Row(                modifier = Modifier
                                .fillMaxWidth()){
                                Column(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF614C91))
                                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                                ) {
                                    Text(
                                        text = "Available funds:",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    userBalance.value?.let { balance ->
                                        Text(
                                            text = "${"%.2f".format(balance)}$",
                                            fontSize = 30.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                    }?: run {
                                        Text(
                                            text = "0.00$",
                                            fontSize = 21.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                    }

                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF614C91))
                                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                                ) {
                                    Row(modifier = Modifier.fillMaxWidth()){
                                        Text(
                                            text = "Inc:",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                        userSalary.value?.let { salary ->
                                            Text(
                                                text = salary.toString() + "$",
                                                fontSize = 22.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White
                                            )
                                        }?: run {
                                            Text(
                                                text = "0.00$",
                                                fontSize = 21.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Row(){
                                        Text(
                                            text = "Exp:",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                        totalCostState.value?.let { totalCost ->
                                            Text(
                                                text = totalCost.toString() + "$",
                                                fontSize = 22.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White
                                            )
                                        }?: run {
                                            Text(
                                                text = "0.00$",
                                                fontSize = 21.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
//                Text(
//                    text = "Statistics:",
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color.White
//                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(8.dp))
//                        .background(Color(0xFF614C91))
//                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                                ) {
                                    Column(                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF614C91))
                                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)) {
                                        Text(
                                            text = "Expenses:",
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                        Row(){
                                            Column(modifier = Modifier
                                                .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
                                                Row(){
                                                    Text(
                                                        text = "Limit: ",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                    userSalary.value?.let { salary ->
                                                        Text(
                                                            text = "${"%.2f".format(salary * selectedModel.b )}$",
                                                            fontSize = 22.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }?: run {
                                                        Text(
                                                            text = "0.00$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                                Row(){
                                                    Text(
                                                        text = "Used: ",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                    sumExState.value?.let { sumEx ->
                                                        Text(
                                                            text = "${"%.2f".format(sumEx)}$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }?: run {
                                                        Text(
                                                            text = "0.00$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                                Row(){
                                                    Text(
                                                        text = "Left: ",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                    sumExState.value?.let { sumEx ->
                                                        userSalary.value?.let { salary ->
                                                            Text(
                                                                text = "${"%.2f".format( (salary * selectedModel.b) - sumEx )}$",
                                                                fontSize = 21.sp,
                                                                fontWeight = FontWeight.SemiBold,
                                                                color = Color.White
                                                            )
                                                        }
                                                    } ?: run {
                                                        Text(
                                                            text = "0.00$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            }
//                            Column(modifier = Modifier
//                                .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                                Text(
//                                    text = "${"%.2f".format(expenses)}$",
//                                    fontSize = 21.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Column(                    modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF614C91))
                                    .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)) {
                                    Text(
                                        text = "Lifestyle:",
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Row(){
                                        Column(modifier = Modifier
                                            .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
                                            Row(){
                                                Text(
                                                    text = "Limit: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                userSalary.value?.let { salary ->
                                                    Text(
                                                        text = "${"%.2f".format(salary * selectedModel.f )}$",
                                                        fontSize = 22.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                            Row(){
                                                Text(
                                                    text = "Used: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                sumLsState.value?.let { sumLs ->
                                                    Text(
                                                        text = "${"%.2f".format(sumLs)}$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                            Row(){
                                                Text(
                                                    text = "Left: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                sumLsState.value?.let { sumLs ->
                                                    userSalary.value?.let { salary ->
                                                        Text(
                                                            text = "${"%.2f".format( (salary * selectedModel.f) - sumLs)}$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                        }
//                            Column(modifier = Modifier
//                                .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                                Text(
//                                    text = "${"%.2f".format(expenses)}$",
//                                    fontSize = 21.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                            }
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))
                                Column(                    modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF614C91))
                                    .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)) {
                                    Text(
                                        text = "Savings:",
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Row(){
                                        Column(modifier = Modifier
                                            .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
                                            Row(){
                                                Text(
                                                    text = "Limit: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                userSalary.value?.let { salary ->
                                                    Text(
                                                        text = "${"%.2f".format(salary * selectedModel.s )}$",
                                                        fontSize = 22.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                            Row(){
                                                Text(
                                                    text = "Used: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                sumSaState.value?.let { sumSa ->
                                                    Text(
                                                        text = "${"%.2f".format(sumSa)}$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                            Row(){
                                                Text(
                                                    text = "Left: ",
                                                    fontSize = 21.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White
                                                )
                                                sumSaState.value?.let { sumSa ->
                                                    userSalary.value?.let { salary ->
                                                        Text(
                                                            text = "${"%.2f".format( (salary * selectedModel.s) - sumSa)}$",
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }?: run {
                                                    Text(
                                                        text = "0.00$",
                                                        fontSize = 21.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                        }
//                            Column(modifier = Modifier
//                                .weight(1f)) {
//                                Text(
//                                    text = "Expenses:",
//                                    fontSize = 22.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                                Text(
//                                    text = "${"%.2f".format(expenses)}$",
//                                    fontSize = 21.sp,
//                                    fontWeight = FontWeight.SemiBold,
//                                    color = Color.White
//                                )
//                            }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Try some models",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(savingsModels) { model ->
                                Box(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = model.gradientColors
                                            )
                                        )
                                        .padding(16.dp)
                                        .fillParentMaxWidth(.8f)
                                        .align(Alignment.CenterHorizontally)
                                ) {
                                    Column {
                                        Text(
                                            text = "Rule: " + model.name,
                                            fontSize = 21.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = model.description,
                                            fontSize = 16.sp,
                                            color = Color.White,
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Button(onClick = { setSelectedModel(model) }) {
                                                Text(text = "Try now!")
                                            }
                                            if (selectedModel == model) {
                                                Text(
                                                    text = "Currently using",
                                                    fontSize = 16.sp,
                                                    color = Color.White,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }

        }




