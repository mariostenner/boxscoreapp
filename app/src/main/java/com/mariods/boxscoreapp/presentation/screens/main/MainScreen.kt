package com.mariods.boxscoreapp.presentation.screens.main

import android.app.StatusBarManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariods.boxscoreapp.presentation.navigation.BottomNavScreen
import com.mariods.boxscoreapp.presentation.navigation.NavigationWrapper
import com.mariods.boxscoreapp.presentation.navigation.itemsBottom
import com.mariods.boxscoreapp.presentation.screens.main.games.GamesScreen
import com.mariods.boxscoreapp.presentation.screens.main.home.HomeScreen
import com.mariods.boxscoreapp.presentation.screens.main.profile.ProfileScreen

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
   val selectedScreen by viewModel.selectedScreen
    Scaffold(
        bottomBar = {
            NavigationBar {
                itemsBottom.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(ImageVector.vectorResource(id = screen.icon), contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = selectedScreen == screen,
                        onClick = { viewModel.selectScreen(screen) }
                    )
                }
            }
        },

    ) { paddingValues ->
        Box(modifier = Modifier
            //.padding(paddingValues)
            .fillMaxSize()) {
            when (selectedScreen) {
                BottomNavScreen.Games -> GamesScreen()
                BottomNavScreen.Home -> HomeScreen()
                BottomNavScreen.Profile -> ProfileScreen()
            }
        }
    }

}


