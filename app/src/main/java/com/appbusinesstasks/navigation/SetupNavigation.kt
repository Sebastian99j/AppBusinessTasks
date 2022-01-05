package com.appbusinesstasks.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.appbusinesstasks.navigation.destinations.loginComposable
import com.appbusinesstasks.navigation.destinations.mainComposable
import com.appbusinesstasks.navigation.destinations.splashComposable
import com.appbusinesstasks.utils.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController
){
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ){
        splashComposable(
            navigateToLoginScreen = screen.splash
        )
        loginComposable(
            navigateToLoginScreen = screen.login
        )
        mainComposable(
            navigateToProfileScreen = screen.main
        )
    }
}