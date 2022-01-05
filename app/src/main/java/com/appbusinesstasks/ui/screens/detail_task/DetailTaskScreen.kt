package com.appbusinesstasks.ui.screens.detail_task

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailTaskScreen(navController: NavController){
    Scaffold {
        Text(text = "DetailTaskScreen", fontWeight = FontWeight.Bold, fontSize = 32.sp, textAlign = TextAlign.Center)
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    DetailTaskScreen(navController = rememberNavController())
}