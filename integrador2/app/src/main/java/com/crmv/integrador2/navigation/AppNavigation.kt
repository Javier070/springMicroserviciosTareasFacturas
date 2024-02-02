package com.crmv.integrador2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crmv.integrador2.views.MisFacturasView
import com.crmv.integrador2.views.MisProyectosView
import com.crmv.integrador2.views.PerfilUsuarioView
import com.crmv.integrador2.views.SubProyectosView

@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.PerfilUsuarioView.path)
    {
        composable(AppScreens.PerfilUsuarioView.path) { PerfilUsuarioView(navigationController) }
        composable(AppScreens.MisFacturasView.path) { MisFacturasView(navigationController) }
        composable(AppScreens.MisProyectosView.path) { MisProyectosView(navigationController) }
        composable(AppScreens.SubProyectosView.path) { SubProyectosView(navigationController) }
    }
}