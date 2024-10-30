package com.mariods.boxscoreapp.presentation.navigation

import SignupScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.mariods.boxscoreapp.presentation.screens.login.LoginScreen
import com.mariods.boxscoreapp.presentation.screens.main.MainScreen
import com.mariods.boxscoreapp.presentation.screens.splash.SplashScreen
import javax.inject.Inject

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen {
                navController.navigate(Login) {
                    popUpTo<Splash> { inclusive = true }
                }
            }
        }
        composable<Login> {
            LoginScreen(
                { navController.navigate(Signup)},
                { navController.navigate(Main) {
                    popUpTo<Login> {inclusive = true}
                } }
            )
        }
        composable<Signup> {
            SignupScreen()
        }
        composable<Main> {
            MainScreen()
        }
    }
}