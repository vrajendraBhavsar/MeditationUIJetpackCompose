package com.plcoding.meditationuiyoutube.model

import androidx.annotation.DrawableRes

data class TopPickData(
    @DrawableRes val restaurantImg: Int,
    val discountPercent: Int,
    val restaurantName: String,
    val approxDeliveryTime: String,
)
