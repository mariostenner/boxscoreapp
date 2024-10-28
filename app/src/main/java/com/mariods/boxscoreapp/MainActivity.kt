package com.mariods.boxscoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mariods.boxscoreapp.presentation.navigation.NavigationWrapper
import com.mariods.boxscoreapp.presentation.ui.theme.BoxScoreAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //val viewModel = View
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxScoreAppTheme {
                //val mainViewModel: MainViewModel = hiltViewModel()
                NavigationWrapper()
                //MainScreen()
            }
        }
    }
}

