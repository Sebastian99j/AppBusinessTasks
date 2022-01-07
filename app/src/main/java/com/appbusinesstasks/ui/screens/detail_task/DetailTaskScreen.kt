package com.appbusinesstasks.ui.screens.detail_task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.R
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.ui.screens.main.BottomMenu
import com.appbusinesstasks.ui.theme.AquaBlue
import com.appbusinesstasks.ui.theme.DeepBlue
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.BottomMenuContext

@Composable
fun DetailTaskScreen(
    sharedViewModel: SharedViewModel,
    taskApi: TaskApi,
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Card(modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)), contentColor = AquaBlue, elevation = 10.dp) {
                Column {
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "Name of task: ${taskApi.name}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "Description of task : ${taskApi.description}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "Start date: ${taskApi.start_date}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "End date: ${taskApi.end_date}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "Status: ${taskApi.status}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "Open: ${taskApi.open}",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(5f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_task),
                        contentDescription = "Task",
                        tint = Color.Black,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Column(
                    modifier = Modifier.weight(5f),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.End
                ) {
                    Icon(
                        painter = if (taskApi.open == "true") {
                            painterResource(id = R.drawable.ic_open)
                        } else painterResource(id = R.drawable.ic_close),
                        contentDescription = "open/close",
                        tint = Color.Blue,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(bottom = 130.dp)
                .height(50.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(30.dp))
                .align(Alignment.BottomCenter)
                .background(Color.Red)
        ) {
            Text(text = "Delete task", modifier = Modifier
                .align(Alignment.Center)
                .clickable { sharedViewModel.deleteTask(taskApi.id!!) })
        }
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