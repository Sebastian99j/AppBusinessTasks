package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.appbusinesstasks.ui.screens.detail_task.DetailTaskScreen
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants
import com.appbusinesstasks.utils.Constants.TASK_DETAIL_ARGUMENT
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.taskDetailComposable(
    sharedViewModel: SharedViewModel,
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToTaskContentScreen: () -> Unit
){
    composable(
        route = Constants.TASK_DETAIL_SCREEN,
        arguments = listOf(navArgument(TASK_DETAIL_ARGUMENT){
            type = NavType.IntType
        })
    ){ navBarStackEntry ->
        val taskId = navBarStackEntry.arguments!!.getInt(TASK_DETAIL_ARGUMENT)

        LaunchedEffect(key1 = taskId, block = {
            sharedViewModel.getSelectedTask(taskId)
        })

        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        DetailTaskScreen(
            taskApi = selectedTask,
            navigateToProfileScreen = navigateToProfileScreen,
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen,
            navigateToTaskContentScreen = navigateToTaskContentScreen,
            sharedViewModel = sharedViewModel
        )
    }
}