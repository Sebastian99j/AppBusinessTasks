package com.appbusinesstasks.ui.screens.profil

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.R
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.ui.screens.main.BottomMenu
import com.appbusinesstasks.ui.theme.AquaBlue
import com.appbusinesstasks.ui.theme.DeepBlue
import com.appbusinesstasks.ui.viewmodels.SharedViewModel
import com.appbusinesstasks.utils.BottomMenuContext

@Composable
fun ProfileScreen(
    navigateToTaskScreen: () -> Unit,
    navigateToMainScreen: () -> Unit,
    sharedViewModel: SharedViewModel
) {
    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    val employee = sharedViewModel.employeeApi.collectAsState()

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
        ProfileImage()
        ContactCard(employee = employee.value)
    }
        BottomMenu(items = listOf(
            BottomMenuContext("Home", R.drawable.ic_home),
            BottomMenuContext("Task", R.drawable.ic_task),
            BottomMenuContext("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter), initialSelectedItemIndex = 2, navigateToTaskScreen = navigateToTaskScreen,
            navigateToMainScreen = navigateToMainScreen, navigateToProfileScreen = {})
    }
}

@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable { mutableStateOf("https://picsum.photos/400/400") }
    val painter = rememberImagePainter (
        if (imageUri.value.isEmpty())
            R.drawable.ic_profile
        else
            imageUri.value,
        builder = {
            crossfade(1000)
            transformations(
                GrayscaleTransformation(),
                RoundedCornersTransformation(50f)
            )
        }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(120.dp)
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable { launcher.launch("image/*") },
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun ContactCard(
    employee: List<EmployeeApi>
){
    Spacer(modifier = Modifier.padding(10.dp))
    Card(modifier = Modifier
        .height(450.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp)), contentColor = AquaBlue, elevation = 10.dp) {
        LazyColumn {
            items(
                items = employee,
                key = { employee ->
                    employee.id
                }) { employee ->
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Name: ${employee.first_name}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )
                }
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Last name: ${employee.last_name}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )
                }
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Gender: ${employee.gender}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )
                }
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Age: ${employee.age}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.End) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                tint = Color.Black,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}
