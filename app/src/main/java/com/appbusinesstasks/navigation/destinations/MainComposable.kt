package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.appbusinesstasks.ui.screens.main.MainScreen
import com.appbusinesstasks.utils.Constants.MAIN_SCREEN

@ExperimentalFoundationApi
@ExperimentalAnimationApi
fun NavGraphBuilder.mainComposable(
    navigateToProfileScreen: () -> Unit
){
    composable(
        route = MAIN_SCREEN
    ){
        MainScreen(navigateToProfileScreen = navigateToProfileScreen)
    }
}