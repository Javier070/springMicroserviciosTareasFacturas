package com.crmv.integrador2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crmv.integrador2.views.items


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 32.dp, end = 16.dp)
    ) {

        OutlinedTextField(
            value = "", onValueChange = { "" },
            label = {
                Text(
                    text = "Buscador",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
             Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp , vertical = 60.dp), maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xff67A4FF), unfocusedBorderColor = Color.Black,
            )
        )
/*
        // Botón de limpiar búsqueda
        if (text.isNotEmpty()) {
            IconButton(
                onClick = { onClearClick() },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
 */

    }
}


//BARRA DE NAVEGACIÓN
@Composable
fun BottomNavigationBar(navController: NavController) {
    // Variable de estado para almacenar el índice de la pantalla activa
    var selectedScreen by remember { mutableStateOf(0) }

    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    // Verifica si el índice actual coincide con el índice de la pantalla activa
                    selected = index == selectedScreen,
                    onClick = {
                        // Actualiza el índice de la pantalla activa al hacer clic en el ícono
                        selectedScreen = index

                        // Navega a la pantalla correspondiente después de actualizar el estado
                        when (index) {
                            0 -> navController.navigate("PerfilUsuarioView")
                            1 -> navController.navigate("MisFacturasView")
                            2 -> navController.navigate("MisProyectosView")
                            3 -> navController.navigate("ruta_pantalla_4")
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}
