package com.appbusinesstasks.ui.screens.add_task

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.ui.theme.*
import com.appbusinesstasks.ui.viewmodels.SharedViewModel

@Composable
fun AddTaskScreen(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

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

    var priority by remember {
        mutableStateOf("priority")
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
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "name") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "description") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = start_date,
            onValueChange = { start_date = it },
            label = { Text(text = "start date") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = end_date,
            onValueChange = { end_date = it },
            label = { Text(text = "end date") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = status,
            onValueChange = { status = it },
            label = { Text(text = "status") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = open,
            onValueChange = { open = it },
            label = { Text(text = "open") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(MEDIUM_PADDING),
            color = AquaBlue
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(AquaBlue)
            .padding(start = 10.dp, end = 10.dp)
            .height(PRIORITY_DROP_DOWN_HEIGHT)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                shape = MaterialTheme.shapes.small
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(8f)
                    .padding(start = 15.dp),
                text = priority,
                style = MaterialTheme.typography.subtitle2
            )
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(fraction = 0.94f) .padding(start = 10.dp, end = 10.dp),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        priority = "LOW"
                    })
                {
                    Text(text = "LOW")
                }
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        priority = "MEDIUM"
                    })
                {
                    Text(text = "MEDIUM")
                }
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        priority = "HIGH"
                    })
                {
                    Text(text = "HIGH")
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .width(150.dp)
                .clickable {
                    if (priority.equals("priority")){
                        Toast.makeText(context, "Choose priority to task!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        sharedViewModel.addTask(
                            TaskApi(
                                id = null,
                                name = name,
                                description = description,
                                start_date = start_date,
                                end_date = end_date,
                                priority = priority,
                                open = open,
                                status = status
                            )
                        )
                        navigateToTaskScreen()
                    }
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
