package com.crmv.integrador2.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.twotone.AccountBalanceWallet
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crmv.integrador2.ui.theme.Integrador2Theme

class LoginView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Integrador2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Textos de bienvenida
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(106.dp))

            Text(
                text = "Inicio de sesión",
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    color = Color(0xE5000000),
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp
                ),
                modifier = Modifier.padding(bottom = 15.dp)
            )

            Text(
                text = "¡Hola de nuevo! Inicia sesión aquí.",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color.Black.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(36.dp))
        }

        // Campos de texto y botón de enviar
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

            )

            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Contraseña") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(width = 1.dp, color = Color.Black) // Borde negro
            )

            Spacer(modifier = Modifier.height(56.dp))

            Button(
                onClick = {

                    // Lógica de inicio de sesión
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62D2C3),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Enviar",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        val (checkedState, onStateChange) = remember { mutableStateOf(true) }

        Column(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .toggleable(
                    value = checkedState,
                    onValueChange = { onStateChange(!checkedState) },
                    role = Role.Checkbox
                )
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {




            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {


            }
        }




        BottomNavigation()

    }


}
@Composable
fun BottomNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(color = Color(0xFF62D2C3)), // Cambiar a color verde


        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = { /* Acción para el primer ícono */ }

        ) {

            Icon(
                Icons.Rounded.List,
                contentDescription = null,
                modifier = Modifier.size(78.dp) // Ajustamos el tamaño del ícono
            )


        }

        IconButton(onClick = { /* Acción para el segundo ícono */ }) {
            Icon(Icons.Rounded.AccountCircle, contentDescription = null,  modifier = Modifier.size(78.dp))
        }
        IconButton(onClick = { /* Acción para el nuevo ícono */ }) {
            Icon(Icons.TwoTone.AccountBalanceWallet, contentDescription = null,  modifier = Modifier.size(78.dp))

        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Integrador2Theme {
        RegisterScreen()

    }
}