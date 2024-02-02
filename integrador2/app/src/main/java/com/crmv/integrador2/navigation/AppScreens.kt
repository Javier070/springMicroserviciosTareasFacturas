package com.crmv.integrador2.navigation

sealed class AppScreens(val path: String) {

    object  PerfilUsuarioView: AppScreens("PerfilUsuarioView")
    object  MisFacturasView: AppScreens("MisFacturasView")
    object  MisProyectosView: AppScreens("MisProyectosView")
    object SubProyectosView: AppScreens("SubProyectosView")
}