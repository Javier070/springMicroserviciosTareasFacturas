package com.crmv.integrador3.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crmv.integrador3.navigation.AppScreens
import com.crmv.integrador3.viewmodels.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    userViewModel: UserViewModel,
    navController: NavController
){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Login") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp, top = 60.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                visualTransformation = PasswordVisualTransformation(),
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                userViewModel.login(username, password)
            }) {
                Text(text = "Login")
            }

            // Observar el resultado del inicio de sesión
            val loginResult by userViewModel.loginResult.observeAsState()

            // Realizar la navegación basada en el resultado del inicio de sesión
            when (loginResult) {
                is UserViewModel.LoginResult.Success -> {
                    // Navegar a la vista de detalles del usuario
                    navController.navigate("userDetails")
                    Log.d("LoginView", "Inicio de sesión exitoso")
                }
                is UserViewModel.LoginResult.Error -> {
                    // Mostrar un mensaje de error descriptivo
                    val errorMessage = "Error de inicio de sesión"
                    Text(text = errorMessage)
                    Log.e("LoginView", "Error de inicio de sesión")
                }
                else -> {
                    // Manejar cualquier otro caso inesperado
                    Log.d("LoginView", "Resultado inesperado del inicio de sesión: $loginResult")
                }
            }

}
    }
}
