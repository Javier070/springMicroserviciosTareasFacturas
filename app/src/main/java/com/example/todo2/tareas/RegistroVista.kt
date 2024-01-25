package com.example.todo2.tareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo2.ui.theme.TODO2Theme

class RegistroVista : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODO2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    @Composable
    fun RegisterScreen() {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Columna para los textos "Bienvenido" y "Vamos a registrarnos"
            Column(
                modifier = Modifier.padding(top = 0.dp, bottom = 16.dp), // Ajusta el padding aquí
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(106.dp))

                // Bienvenido
                Text(
                    text = "Registro",
                    style = TextStyle(
                        fontWeight = FontWeight.W700,
                        color = Color(0xE5000000),
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp
                    ),
                    modifier = Modifier.padding(bottom = 15.dp)
                )

                // Vamos a registrarnos
                Text(
                    text = "¡Bienvenido! Regístrate para comenzar.",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color.Black.copy(alpha = 0.5f), // Color negro apagado
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(36.dp))
            }

            // Columna principal para los TextField y el Button
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text("Nombre de usuario") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(16.dp))


                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(16.dp))

                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("contraseña") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .border(width = 1.dp, color = Color.Black) // Agrega el borde negro

                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Confirmar contraseña") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .border(width = 1.dp, color = Color.Black) // Agrega el borde negro



                )

                Spacer(modifier = Modifier.height(56.dp))
                Button(
                    onClick = {
                        // Perform registration logic here
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(6.dp), // Ajusta el radio de las esquinas según tus preferencias
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF62D2C3),
                        contentColor = Color.Black
                    ),

                    ) {
                    Text(
                        text = "Enviar",
                        style = TextStyle(
                            fontSize = 24.sp, // Ajusta el tamaño de la fuente según tus preferencias
                            fontWeight = FontWeight.Bold
                        )
                    )
                }


            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TODO2Theme {
            RegisterScreen()
        }
    }
}