package com.appbusinesstasks.ui.screens.main

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
fun MainScreen(
    navigateToProfileScreen: () -> Unit
){
    Scaffold {
        Text(text = "MainScreen", fontWeight = FontWeight.Bold, fontSize = 32.sp, textAlign = TextAlign.Center)
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    MainScreen(navigateToProfileScreen = {})
}