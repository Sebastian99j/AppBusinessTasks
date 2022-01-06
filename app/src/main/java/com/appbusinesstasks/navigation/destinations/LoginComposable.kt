package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.sign_in.LoginViewModel
import com.google.accompanist.navigation.animation.composable
import com.appbusinesstasks.ui.screens.sign_in.SignInScreen
import com.appbusinesstasks.utils.Constants.LOGIN_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.loginComposable(
    navigateToLoginScreen: () -> Unit,
    loginViewModel: LoginViewModel
){
    composable(
        route = LOGIN_SCREEN
    ){
        SignInScreen(
            navigateToMainScreen = navigateToLoginScreen,
            loginViewModel = loginViewModel
        )
    }
}