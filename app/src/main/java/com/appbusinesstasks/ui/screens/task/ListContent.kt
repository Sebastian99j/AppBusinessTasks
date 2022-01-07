package com.appbusinesstasks.ui.screens.task

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun ListContent(
    listOfTasks: List<TaskApi>,
    navigateToTaskDetailScreen: (Int) -> Unit
){
    if (listOfTasks.isEmpty()){
        EmptyContent()
    }
    else {
        DisplayTasks(
            listOfTasks = listOfTasks,
            navigateToTaskDetailScreen = navigateToTaskDetailScreen
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    listOfTasks: List<TaskApi>,
    navigateToTaskDetailScreen: (Int) -> Unit
){
    LazyColumn{
        items(
            items = listOfTasks,
            key = { task ->
                task.id!!
            }
        ){ task ->
            TaskItem(
                taskApi = task,
                navigateToTaskDetailScreen = navigateToTaskDetailScreen
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    taskApi: TaskApi,
    navigateToTaskDetailScreen: (Int) -> Unit
){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = AquaBlue,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskDetailScreen(taskApi.id!!.toInt())
        })
    {
        Column(modifier = Modifier
            .padding(all = LARGE_PADDING)
            .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = taskApi.name,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ){
                    Canvas(
                        modifier = Modifier
                            .width(PRIORITY_INDICATOR_SIZE)
                            .height(PRIORITY_INDICATOR_SIZE)
                    ){
                        drawCircle(
                            color = if (taskApi.status == "LOW") Color.Red else if (taskApi.status == "MEDIUM") Color.Yellow else Color.Green
                        ) 
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = taskApi.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}