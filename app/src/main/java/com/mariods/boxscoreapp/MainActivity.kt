package com.mariods.boxscoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.auth.FirebaseAuth
import com.mariods.boxscoreapp.presentation.navigation.NavigationWrapper
import com.mariods.boxscoreapp.presentation.ui.theme.BoxScoreAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
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

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        if(currentUser != null){
            firebaseAuth.signOut()
        }
    }
}

