package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.help.HelpScreen
import com.appbusinesstasks.utils.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.helpComposable(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
){
    composable(
        route = Constants.HELP_SCREEN
    ){
        HelpScreen(
            navigateToProfileScreen = navigateToProfileScreen,
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen
        )
    }
}