package com.mariods.boxscoreapp.presentation.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth) : ViewModel() {
    private val _authState = MutableLiveData<Boolean>()
    val authState: LiveData<Boolean> = _authState

    fun authFirebase(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _authState.value = task.isSuccessful
                Log.i("AUTENTICANDO","Entro al state")
            }
    }
}