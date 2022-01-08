package com.appbusinesstasks.ui.screens.content_task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.R
import com.appbusinesstasks.ui.screens.main.BottomMenu
import com.appbusinesstasks.ui.theme.*
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.BottomMenuContext

@Composable
fun ContentTask(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToTaskDetailScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    val selectedTask = sharedViewModel.selectedTask.collectAsState()

    var comment by remember {
        mutableStateOf("")
    }

    var completion by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)) {
                LinearProgressIndicator(progress = (selectedTask.value.completion?.toFloat() ?: 0f)/100,
                    color = Color.Green, modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth())
            }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(8.dp, top = 50.dp),
            ) {
            if (selectedTask.value.comments!!.isNotEmpty()){
                selectedTask.value.comments?.forEach {
                    ListOfComments(it)
                }
            }
            else {
                ListOfComments("This task don't have comments.")
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Divider(
                modifier = Modifier
                    .height(MEDIUM_PADDING),
                color = Color.Black
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                value = completion,
                onValueChange = { completion = it },
                label = { Text(text = "completion", color = TextWhite) },
                textStyle = MaterialTheme.typography.body1,
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    textColor = TextWhite)
            )
            Divider(
                modifier = Modifier
                    .height(MEDIUM_PADDING),
                color = DeepBlue
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                value = comment,
                onValueChange = { comment = it },
                label = { Text(text = "comment", color = TextWhite) },
                textStyle = MaterialTheme.typography.body1,
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    textColor = TextWhite)
            )
            Divider(
                modifier = Modifier
                    .height(MEDIUM_PADDING),
                color = DeepBlue
            )
            Box(
                modifier = Modifier
                    .padding(10.dp, top = 40.dp)
                    .height(50.dp)
                    .width(150.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Black)
            ) {
                Text(text = "Save comment", modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {
                        sharedViewModel.sendComment(completion = completion, comment = comment)
                        navigateToTaskDetailScreen(sharedViewModel.selectedTask.value.id!!.toInt())
                    },
                color = TextWhite)
            }
        }
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

@Composable
fun ListOfComments(
    item: String
){
    Spacer(modifier = Modifier.padding(10.dp))
    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)), contentColor = AquaBlue, elevation = 10.dp
    ) {
        Column {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Comments: $item",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )
            }
        }
    }
}
