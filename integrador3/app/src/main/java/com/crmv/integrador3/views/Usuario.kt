package com.crmv.integrador3.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.crmv.integrador3.data.user.User

@Composable
fun Usuario(user: User) {
    // Aquí puedes mostrar los detalles del usuario
    Text(text = "Username: ${user.username}")
    Text(text = "Name: ${user.firstName} ${user.lastName}")
    Text(text = "Email: ${user.email}")
    // Agrega más detalles según sea necesario
}
