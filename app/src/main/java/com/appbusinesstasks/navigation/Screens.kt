package com.appbusinesstasks.navigation

import androidx.navigation.NavHostController
import com.appbusinesstasks.utils.Constants.LOGIN_SCREEN
import com.appbusinesstasks.utils.Constants.MAIN_SCREEN
import com.appbusinesstasks.utils.Constants.PROFILE_SCREEN
import com.appbusinesstasks.utils.Constants.SPLASH_SCREEN
import com.appbusinesstasks.utils.Constants.TASK_DETAIL_SCREEN
import com.appbusinesstasks.utils.Constants.TASK_SCREEN

class Screens(navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate(route = LOGIN_SCREEN){
            popUpTo(SPLASH_SCREEN){ inclusive = true }
        }
    }
    val login: () -> Unit = {
        navController.navigate(route = MAIN_SCREEN){
            popUpTo(LOGIN_SCREEN){ inclusive = true }
        }
    }
    val main: () -> Unit = {
        navController.navigate(route = PROFILE_SCREEN){
            popUpTo(MAIN_SCREEN){ inclusive = true }
        }
    }
    val toTask: () -> Unit = {
        navController.navigate(route = TASK_SCREEN){
            popUpTo(MAIN_SCREEN){ inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("taskDetail/$taskId"){
            popUpTo(TASK_SCREEN){ inclusive = true }
        }
    }
    val profile: () -> Unit = {
        navController.navigate(route = MAIN_SCREEN){
            popUpTo(PROFILE_SCREEN){ inclusive = true }
        }
    }
    val taskDetail: () -> Unit = {
        navController.navigate(route = TASK_SCREEN){
            popUpTo(TASK_DETAIL_SCREEN){ inclusive = true }
        }
    }
}