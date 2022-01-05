package com.appbusinesstasks.core.data.models

import androidx.compose.ui.graphics.Color
import com.appbusinesstasks.ui.theme.HighPriorityColor
import com.appbusinesstasks.ui.theme.LowPriorityColor
import com.appbusinesstasks.ui.theme.MediumPriorityColor
import com.appbusinesstasks.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}