package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.content_task.ContentTask
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.contentTaskComposable(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToTaskDetailScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = Constants.TASK_CONTENT_SCREEN
    ){
        ContentTask(
            navigateToMainScreen = navigateToMainScreen,
            navigateToProfileScreen = navigateToProfileScreen,
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToTaskDetailScreen = navigateToTaskDetailScreen,
            sharedViewModel = sharedViewModel
        )
    }
}