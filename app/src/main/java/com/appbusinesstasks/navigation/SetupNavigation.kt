package com.appbusinesstasks.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.appbusinesstasks.navigation.destinations.*
import com.appbusinesstasks.ui.screens.sign_in.LoginViewModel
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    sharedViewModel: SharedViewModel
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
            navigateToLoginScreen = screen.login,
            loginViewModel = loginViewModel
        )
        mainComposable(
            navigateToProfileScreen = screen.main,
            navigateToTaskScreen = screen.toTask,
            navigateToHelpScreen = screen.toHelp,
            sharedViewModel = sharedViewModel
        )
        profileComposable(
            navigateToTaskScreen = screen.toTask,
            navigateToMainScreen = screen.login,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToTaskDetailScreen = screen.task,
            sharedViewModel = sharedViewModel,
            navigateToAddTaskScreen = screen.toAddTask
        )
        taskDetailComposable(
            sharedViewModel = sharedViewModel,
            navigateToProfileScreen = screen.main,
            navigateToTaskScreen = screen.toTask,
            navigateToMainScreen = screen.login
        )
        addTaskComposable(
            sharedViewModel = sharedViewModel,
            navigateToTaskScreen = screen.toTask
        )
    }
}