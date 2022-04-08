package com.plcoding.meditationuiyoutube.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object CommonUtils {
    @Composable
    fun SectionSeparator(topPadding: Dp = 5.dp, bottomPadding: Dp = 5.dp,thickness: Dp = 2.dp) {
        Spacer(modifier = Modifier.fillMaxWidth().padding(topPadding))
        Divider(modifier = Modifier.fillMaxWidth(), thickness = thickness)
        Spacer(modifier = Modifier.fillMaxWidth().padding(bottomPadding))
    }
}