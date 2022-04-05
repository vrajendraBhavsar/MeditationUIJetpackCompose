package com.plcoding.meditationuiyoutube.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconRes: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
