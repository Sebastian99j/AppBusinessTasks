package com.appbusinesstasks.ui.screens.add_task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.ui.theme.AquaBlue
import com.appbusinesstasks.ui.theme.DarkerButtonBlue
import com.appbusinesstasks.ui.theme.TextWhite
import com.appbusinesstasks.ui.viewmodels.SharedViewModel

@Composable
fun AddTaskScreen(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: () -> Unit
){
    var name by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var start_date by remember {
        mutableStateOf("")
    }

    var end_date by remember {
        mutableStateOf("")
    }

    var status by remember {
        mutableStateOf("")
    }

    var open by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AquaBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Add new task!", color = TextWhite, style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = name,
            onValueChange = {name = it},
            label = {
                Text(text = "name")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = description,
            onValueChange = {description = it},
            label = {
                Text(text = "description")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = start_date,
            onValueChange = {start_date = it},
            label = {
                Text(text = "start_date")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = end_date,
            onValueChange = {end_date = it},
            label = {
                Text(text = "end_date")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = status,
            onValueChange = {status = it},
            label = {
                Text(text = "status")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = open,
            onValueChange = {open = it},
            label = {
                Text(text = "open")
            }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .width(150.dp)
                .clickable {
                    sharedViewModel.addTask(
                        TaskApi(
                            id = null,
                            name = name,
                            description = description,
                            start_date = start_date,
                            end_date = end_date,
                            open = open,
                            status = status
                        )
                    )
                    navigateToTaskScreen()
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    DarkerButtonBlue
                )
                .padding(15.dp)
        ) {
            Text(text = "ADD TASK", color = TextWhite)
        }
    }
}
