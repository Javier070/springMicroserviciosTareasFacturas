package com.crmv.integrador3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crmv.integrador3.data.proyecto.ProyectoViewModel
import com.crmv.integrador3.viewmodels.UserViewModel
import com.crmv.integrador3.views.LoginView
import com.crmv.integrador3.views.ProyectosView
import com.crmv.integrador3.views.RegisterView
import com.crmv.integrador3.views.Usuario


@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()
    val proyectoViewModel: ProyectoViewModel = viewModel()

    NavHost(navController = navigationController, startDestination = AppScreens.ProyectosView.path) {
        composable(AppScreens.LoginView.path) {
            LoginView(userViewModel = userViewModel, navController = navigationController)
        }

        composable(AppScreens.RegisterView.path) {
            RegisterView(userViewModel = userViewModel, navController = navigationController)
        }

        composable(AppScreens.Usuario.path) { // Cambio aquí
            val user = userViewModel.navigateToUserDetails.observeAsState().value
            if (user != null) {
                Usuario(user = user)
            }
        }
        composable(AppScreens.ProyectosView.path) {
            // Observar los proyectos y el error desde el ProyectoViewModel
            val proyectos by proyectoViewModel.proyectos.observeAsState(initial = emptyList())
            val error by proyectoViewModel.error.observeAsState(initial = false)

            // Renderizar la vista de proyectos
            ProyectosView(proyectoViewModel)
        }
    }
}
