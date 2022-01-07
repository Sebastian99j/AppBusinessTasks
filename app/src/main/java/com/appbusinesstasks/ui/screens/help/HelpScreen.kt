package com.appbusinesstasks.ui.screens.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.R
import com.appbusinesstasks.ui.screens.main.BottomMenu
import com.appbusinesstasks.ui.theme.AquaBlue
import com.appbusinesstasks.ui.theme.DeepBlue
import com.appbusinesstasks.ui.theme.TextWhite
import com.appbusinesstasks.utils.BottomMenuContext

@Composable
fun HelpScreen(
    navigateToProfileScreen: () -> Unit,
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AquaBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
            Text(
                text = "Support",
                color = TextWhite,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(15.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Green circle is low priority",
                color = TextWhite,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Orange circle is medium priority",
                color = TextWhite,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Red circle is high priority",
                color = TextWhite,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        BottomMenu(
            items = listOf(
                BottomMenuContext("Home", R.drawable.ic_home),
                BottomMenuContext("Task", R.drawable.ic_task),
                BottomMenuContext("Profile", R.drawable.ic_profile),
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            initialSelectedItemIndex = 0,
            navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen,
            navigateToProfileScreen = navigateToProfileScreen
        )
    }
}