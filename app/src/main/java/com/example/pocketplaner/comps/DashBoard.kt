package com.example.pocketplaner.comps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SavingsModel(
    val name: String,
    val description: String,
    val gradientColors: List<Color>
)
@Composable
fun DashBoard(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF815BD8), Color(0xFF2B0B75))
                )
            )
            .padding(start = 10.dp, top = 25.dp, end = 10.dp, bottom = 110.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF4F3A7E))
                .padding(8.dp)
        ) {
            Text(
                text = "Welcome back, " + "Michał",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "2341.12" + "$",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF614C91))
                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "rachunki",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = "989.12" + "$",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF614C91))
                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "zabawa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = "189.12" + "$",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF614C91))
                        .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "inwestycje",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = "432.12" + "$",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
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
            val savingsModels = listOf(
                SavingsModel(
                    name = "Zasada 50/30/20",
                    description = "Save 50% on essentials, 30% on lifestyle, and 20% on savings.",
                    gradientColors = listOf(Color(0xFF815BD8), Color(0xFF2B0B75))
                ),
                SavingsModel(
                    name = "Zasada 80/20",
                    description = "Spend 80% on necessities and save 20%.",
                    gradientColors = listOf(Color(0xFFE7A1FE), Color(0xFF4B0082))
                ),
                SavingsModel(
                    name = "Zasada 70/20/10",
                    description = "Allocate 70% for living expenses, 20% for savings, and 10% for investments.",
                    gradientColors = listOf(Color(0xFF7FFFD4), Color(0xFF00CED1))
                ),
                SavingsModel(
                    name = "Zasada 60/20/20",
                    description = "Use 60% for essentials, 20% for lifestyle, and 20% for savings.",
                    gradientColors = listOf(Color(0xFFFFD700), Color(0xFFFF6347))
                )
            )
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
                            text = model.name,
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
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Try now!")
                        }
                    }
                }
            }
        }
    }
}