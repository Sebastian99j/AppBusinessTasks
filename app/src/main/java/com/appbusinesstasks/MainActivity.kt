package com.appbusinesstasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import com.appbusinesstasks.navigation.SetupNavigation
import com.appbusinesstasks.ui.screens.sign_in.LoginViewModel
import com.appbusinesstasks.ui.theme.AppBusinessTasksTheme
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val loginViewModel: LoginViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBusinessTasksTheme {
                navController = rememberAnimatedNavController()
                SetupNavigation(
                    navController = navController,
                    loginViewModel = loginViewModel,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
