package com.appbusinesstasks.ui.screens.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.appbusinesstasks.R
import com.appbusinesstasks.ui.theme.AppBusinessTasksTheme
import com.appbusinesstasks.ui.theme.LOGO_HEIGHT
import com.appbusinesstasks.ui.theme.splashScreenBackground
import kotlinx.coroutines.delay
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.appbusinesstasks.utils.Constants.SPLASH_SCREEN_DELAY

@Composable
fun SplashScreen(
    navigateToLoginScreen: () -> Unit
){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val offSetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else (-200).dp,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true, block = {
        startAnimation = true
        delay(SPLASH_SCREEN_DELAY)
        navigateToLoginScreen()
    })

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.splashScreenBackground),
        contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier
                .size(LOGO_HEIGHT)
                .offset(y = offSetState)
                .alpha(alpha = alphaState),
            painter = painterResource(id = getLogo()),
            contentDescription = stringResource(id = R.string.jetpack_logo)
        )
    }
}

@Composable
fun getLogo(): Int {
    return if (isSystemInDarkTheme()){
        R.drawable.ic_logo_dark
    }
    else {
        R.drawable.ic_logo_light
    }
}

@Composable
@Preview
private fun SplashScreenPreview(){
    SplashScreen(
        navigateToLoginScreen = {}
    )
}

@Composable
@Preview
private fun SplashScreenPreview2(){
    AppBusinessTasksTheme(darkTheme = true) {
        SplashScreen(
            navigateToLoginScreen = {}
        )
    }
}