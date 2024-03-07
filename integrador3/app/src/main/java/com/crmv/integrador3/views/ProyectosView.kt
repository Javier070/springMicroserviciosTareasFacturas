package com.crmv.integrador3.views

import com.crmv.integrador3.data.proyecto.ProyectoViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ProyectosView(proyectoViewModel: ProyectoViewModel = viewModel()) {
    LaunchedEffect(key1 = true) {
        proyectoViewModel.getProyectos()
    }
    val proyectos by proyectoViewModel.proyectos.observeAsState(initial = emptyList())
    val error by proyectoViewModel.error.observeAsState(initial = false)

    Surface {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (error == true) { // Aquí se verifica si error es true
                Text(text = "Error al obtener los proyectos")
            } else {
                for (proyecto in proyectos) {
                    Text(text = "Nombre: ${proyecto.nombre}")
                    Text(text = "Descripción: ${proyecto.descripcion}")
                    // Agrega más información del proyecto según sea necesario
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
