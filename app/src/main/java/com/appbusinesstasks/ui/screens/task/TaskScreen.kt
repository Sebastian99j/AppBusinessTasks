package com.appbusinesstasks.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.R
import com.appbusinesstasks.ui.screens.main.BottomMenu
import com.appbusinesstasks.ui.theme.DeepBlue
import com.appbusinesstasks.ui.theme.fabBackgroundColor
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.BottomMenuContext
import com.appbusinesstasks.utils.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun TaskScreen(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToDetailTaskScreen: (Int) -> Unit,
    navigateToAddTaskScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    LaunchedEffect(key1 = true){
        sharedViewModel.loadData()
    }

    val listOfTasks = sharedViewModel.userTask.collectAsState()
    
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
    ) {
    Scaffold(
        modifier = Modifier.background(Color.Blue),
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                listOfTasks = listOfTasks.value,
                navigateToTaskDetailScreen = navigateToDetailTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(onFabClick = navigateToAddTaskScreen)
        }
    )
        BottomMenu(
            items = listOf(
                BottomMenuContext("Home", R.drawable.ic_home),
                BottomMenuContext("Task", R.drawable.ic_task),
                BottomMenuContext("Profile", R.drawable.ic_profile),
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            initialSelectedItemIndex = 1,
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen,
            navigateToProfileScreen = navigateToProfileScreen
        )
    }
}

@Composable
fun ListFab(
    onFabClick: () -> Unit
){
    FloatingActionButton(
        modifier = Modifier.padding(bottom = 100.dp),
        onClick = {
            onFabClick()
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}