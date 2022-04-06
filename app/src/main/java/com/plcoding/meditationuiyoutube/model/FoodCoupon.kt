package com.plcoding.meditationuiyoutube.model

import androidx.annotation.DrawableRes

data class FoodCoupon(
    @DrawableRes val imageId: Int,
    val offPercent: Int,
    val UpToOffCashAmount: Int,
    @DrawableRes val cashBackPartnerImageId: Int
)