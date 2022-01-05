package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.splash.SplashScreen
import com.appbusinesstasks.utils.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToLoginScreen: () -> Unit
){
    composable(
        route = SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(300)
            )
        }
    ){
        SplashScreen (
            navigateToLoginScreen = navigateToLoginScreen
        )
    }
}