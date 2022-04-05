package com.plcoding.meditationuiyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.meditationuiyoutube.ui.theme.HomeScreen
import com.plcoding.meditationuiyoutube.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {
//    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen(this)
            }
        }
    }


    @Preview
    @Composable
    fun DefaultPreview() {
        MeditationUIYouTubeTheme {
            HomeScreen(context = this)
        }
    }
}