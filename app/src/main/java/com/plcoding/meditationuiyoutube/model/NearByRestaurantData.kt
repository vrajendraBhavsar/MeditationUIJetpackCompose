package com.plcoding.meditationuiyoutube.model

import androidx.annotation.DrawableRes
import com.plcoding.meditationuiyoutube.R

data class NearByRestaurantData(
    @DrawableRes val restaurantImg: Int,
    val discountPercent: Int,
    val restaurantName: String,
    val availableCuisines: List<String>,
    val location: String,
    val distance: Int,
    val ratings: Float,
    val approxDeliveryTime: String,
    val costForTwo: Int,
    @DrawableRes val offerImg: Int = R.drawable.ic_offer,
    val extraOfferPercentage: Int,
    val extraOfferUpto: Int,
)
