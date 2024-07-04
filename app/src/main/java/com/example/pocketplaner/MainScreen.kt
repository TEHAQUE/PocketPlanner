package com.example.pocketplaner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModelProvider
import com.example.pocketplaner.comps.DashBoard
import com.example.pocketplaner.comps.HomePage
import com.example.pocketplaner.comps.NotifPage
import com.example.pocketplaner.comps.OperationsPage

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItemList = listOf(
        ItemNav("Home", Icons.Default.Home),
        ItemNav("Dashboard", Icons.Default.List),
        ItemNav("Operations", Icons.Default.Add),
        ItemNav("Notifications", Icons.Default.Notifications),
    )
    var clickedBtn by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    bottomBar ={
        NavigationBar(modifier = Modifier.background(Color.LightGray),
            containerColor = Color.Transparent,
            contentColor = Color.White    ) {
            navItemList.forEachIndexed{ index, itemNav ->
                NavigationBarItem(
                    selected = clickedBtn == index,
                    onClick = { clickedBtn = index },
                    icon = {
                            Icon(imageVector = itemNav.icon, contentDescription = "Icon")},

                    label = {
                        Text(
                            text = itemNav.label,
                            color = if (clickedBtn == index) Color.DarkGray else Color.Black,
                            fontWeight = if (clickedBtn == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }
    }
    ){ innerPadding ->
        ContentWrapper(modifier=Modifier.padding(innerPadding),clickedBtn)
    }
}

@Composable
fun ContentWrapper(modifier: Modifier = Modifier, clickedBtn : Int) {
    when(clickedBtn){
        0-> HomePage()
        1-> DashBoard()
        2-> OperationsPage()
        3-> NotifPage()
    }
}