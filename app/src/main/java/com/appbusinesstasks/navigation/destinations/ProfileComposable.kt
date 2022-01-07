package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.profil.ProfileScreen
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.profileComposable(
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = Constants.PROFILE_SCREEN
    ){
        ProfileScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen,
            sharedViewModel = sharedViewModel
        )
    }
}