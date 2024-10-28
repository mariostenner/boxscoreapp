package com.mariods.boxscoreapp.presentation.navigation

import com.mariods.boxscoreapp.R


sealed class BottomNavScreen(val title: String, val icon: Int) {
    data object Games : BottomNavScreen("Games", R.drawable.ic_baseball)
    data object Home : BottomNavScreen("Home", R.drawable.icon_home)
    data object Profile : BottomNavScreen("Profile", R.drawable.icon_profile)
}



var itemsBottom = listOf(
BottomNavScreen.Games,
BottomNavScreen.Home,
BottomNavScreen.Profile
)



