package com.mariods.boxscoreapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mariods.boxscoreapp.presentation.screens.login.LoginScreen
import com.mariods.boxscoreapp.presentation.screens.main.MainScreen
import com.mariods.boxscoreapp.presentation.screens.splash.SplashScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen { navController.navigate(Main){
                popUpTo<Splash>{inclusive = true}
            } }
        }
        composable<Login> {
            LoginScreen()
        }

        composable<Main> {
            MainScreen()
        }
    }
}