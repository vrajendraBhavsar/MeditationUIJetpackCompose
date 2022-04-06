package com.plcoding.meditationuiyoutube.model

import androidx.annotation.DrawableRes

data class TopBrandData(
    @DrawableRes val brandImg: Int,
    val discountPercent: Int,
    val brandName: String,
    val approxDeliveryTime: String,
)
