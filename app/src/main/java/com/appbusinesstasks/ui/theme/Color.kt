package com.appbusinesstasks.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val DeepBlue2 = Color(0xFF122A7A)
val Teal200 = Color(0xFF03DAC5)

val TextWhite = Color(0xffeeeeee)
val DeepBlue = Color(0xff06164c)
val ButtonBlue = Color(0xff505cf3)
val DarkerButtonBlue = Color(0xff566894)
val LightRed = Color(0xfffc879a)
val AquaBlue = Color(0xff9aa5c4)
val OrangeYellow1 = Color(0xfff0bd28)
val OrangeYellow2 = Color(0xfff1c746)
val OrangeYellow3 = Color(0xfff4cf65)
val Beige1 = Color(0xfffdbda1)
val Beige2 = Color(0xfffcaf90)
val Beige3 = Color(0xfff9a27b)
val LightGreen1 = Color(0xff54e1b6)
val LightGreen2 = Color(0xff36ddab)
val LightGreen3 = Color(0xff11d79b)
val BlueViolet1 = Color(0xffaeb4fd)
val BlueViolet2 = Color(0xff9fa5fe)
val BlueViolet3 = Color(0xff8f98fd)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = MediumGray

val Colors.splashScreenBackground: Color
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.Blue else Purple700
