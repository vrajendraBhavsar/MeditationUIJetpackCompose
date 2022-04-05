package com.plcoding.meditationuiyoutube

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

// To manage path smoothness with their x1, y1, x2, y2

fun Path.standardQuadFromTo(from: Offset, to: Offset) { // Fun to draw smooth lines
    quadraticBezierTo( //Draw a line to the second point, and to smoothen that line to give it curve
        from.x,
        from.y,
        abs((from.x + to.x) / 2f), //abs() ->to get/convert to the positive value
        abs((from.y + to.y) / 2f)
    )
    //these 3rd and 4th param (x2 and y2) will decide how curve will look like
}
