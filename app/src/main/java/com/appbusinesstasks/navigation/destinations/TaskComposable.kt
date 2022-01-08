package com.appbusinesstasks.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import com.appbusinesstasks.ui.screens.task.TaskScreen
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToTaskDetailScreen: (Int) -> Unit,
    navigateToAddTaskScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = Constants.TASK_SCREEN
    ){
       TaskScreen(
           navigateToDetailTaskScreen = navigateToTaskDetailScreen,
           sharedViewModel = sharedViewModel,
           navigateToAddTaskScreen = navigateToAddTaskScreen,
           navigateToProfileScreen = navigateToProfileScreen,
           navigateToTaskScreen = navigateToTaskScreen,
           navigateToMainScreen = navigateToMainScreen
       )
    }
}