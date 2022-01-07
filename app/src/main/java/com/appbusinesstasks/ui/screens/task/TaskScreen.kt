package com.appbusinesstasks.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.appbusinesstasks.R
import com.appbusinesstasks.ui.theme.fabBackgroundColor
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun TaskScreen(
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
}

@Composable
fun ListFab(
    onFabClick: () -> Unit
){
    FloatingActionButton(
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