package com.mariods.boxscoreapp.presentation.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mariods.boxscoreapp.presentation.navigation.BottomNavScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _selectedScreen = mutableStateOf<BottomNavScreen>(BottomNavScreen.Home)
    val selectedScreen: State<BottomNavScreen> = _selectedScreen

    fun selectScreen(screen: BottomNavScreen) {
        _selectedScreen.value = screen
    }
}