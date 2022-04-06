package com.plcoding.meditationuiyoutube


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.meditationuiyoutube.ui.homeScreen.HomeScreen

class MainActivity : ComponentActivity() {
    //    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MeditationUIYouTubeTheme {
            HomeScreen()
//            }
        }
    }

//    @Preview
//    @Composable
//    fun DefaultPreview() {
//        MeditationUIYouTubeTheme {
//
//        }
//    }
}