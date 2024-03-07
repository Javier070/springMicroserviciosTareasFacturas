package com.crmv.integrador3.navigation

sealed class AppScreens(val path: String) {
    object LoginView: AppScreens("login")
    object RegisterView: AppScreens("register")
    object Usuario: AppScreens("usuiaro") // Agregar esta línea
    object ProyectosView: AppScreens("proyectosView")
}

