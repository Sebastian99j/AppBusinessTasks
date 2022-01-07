package com.appbusinesstasks.core.data.models

data class JetpackTask(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)