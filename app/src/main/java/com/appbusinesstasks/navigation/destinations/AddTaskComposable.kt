package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.add_task.AddTaskScreen
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.addTaskComposable(
    navigateToTaskScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = Constants.ADD_TASK_SCREEN
    ){
        AddTaskScreen(
            sharedViewModel = sharedViewModel,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}