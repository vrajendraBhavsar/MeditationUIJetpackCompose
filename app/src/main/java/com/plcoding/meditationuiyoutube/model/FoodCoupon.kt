package com.plcoding.meditationuiyoutube.model

import androidx.compose.ui.graphics.Color
import android.graphics.LinearGradient
import androidx.annotation.DrawableRes

data class FoodCoupon(
    @DrawableRes val imageId: Int,
    val offPercent: Int,
    val upToOffCashAmount: Int,
    @DrawableRes val cashBackPartnerImageId: Int,
    val colorGradient: List<Color>
)