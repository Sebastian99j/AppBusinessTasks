package com.appbusinesstasks.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.appbusinesstasks.utils.Constants.LOGIN_SCREEN
import com.appbusinesstasks.utils.Constants.MAIN_SCREEN

fun NavGraphBuilder.mainComposable(
    navigateToProfileScreen: () -> Unit
){
    composable(
        route = MAIN_SCREEN
    ){

    }
}