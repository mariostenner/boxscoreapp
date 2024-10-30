package com.mariods.boxscoreapp.presentation.screens.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariods.boxscoreapp.presentation.ui.theme.PrincipalBlue
import com.mariods.boxscoreapp.presentation.ui.theme.PrincipalGreen
import com.mariods.boxscoreapp.presentation.ui.theme.SecondaryBlue
import com.mariods.boxscoreapp.presentation.ui.theme.SecondaryGreen

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun LoginScreen(
    navigateToSignUp: () -> Unit = {},
    navigateToMain: () -> Unit = {},
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val authState by viewModel.authState.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        //verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "IDENTIFICATE",
            color = PrincipalGreen,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,

            )
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .border(3.dp, PrincipalGreen, RoundedCornerShape(10.dp)),
            placeholder = { Text(text = "usuario@gmail.com") },
            label = { Text(text = "Ingresa tu usuario") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .border(3.dp, PrincipalGreen, RoundedCornerShape(10.dp)),
            label = { Text(text = "Ingresa tu contraseña") },
            //visualTransformation = VisualTransformation{}
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { viewModel.authFirebase(email, password) },
            colors = ButtonColors(PrincipalBlue, PrincipalGreen, SecondaryGreen, SecondaryBlue),
            modifier = Modifier
                .fillMaxWidth()
                .background(PrincipalBlue, RoundedCornerShape(10.dp))
        ) {
            Text(text = "ENTRAR", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigateToSignUp() },
            colors = ButtonColors(PrincipalBlue, PrincipalGreen, SecondaryGreen, SecondaryBlue),
            modifier = Modifier
                .fillMaxWidth()
                .background(PrincipalBlue, RoundedCornerShape(10.dp))
        ) {
            Text(text = "REGISTRARME", color = Color.White)
        }
        authState?.let { isLoggedIn ->
            if (isLoggedIn) {
                LaunchedEffect(Unit) {
                    navigateToMain()
                }
            } else {
                Text(text = "Usuario o Contraseña incorrecta intente de nuevo", color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }


}