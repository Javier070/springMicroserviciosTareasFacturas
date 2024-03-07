package com.crmv.integrador3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.crmv.integrador3.data.UserApi
import com.crmv.integrador3.data.user.UserRepository
import com.crmv.integrador3.navigation.AppNavigation
import com.crmv.integrador3.ui.theme.Integrador3Theme
import com.crmv.integrador3.viewmodels.UserViewModel
import com.crmv.integrador3.viewmodels.LoginViewModelFactory


class MainActivity : ComponentActivity() {

    private val userService = UserApi.userService // Obtener la instancia de UserService desde UserApi

    private val userRepository = UserRepository(userService) // Crear UserRepository con el servicio de UserService

    private val userViewModel by viewModels<UserViewModel> { LoginViewModelFactory(userRepository) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Integrador3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
