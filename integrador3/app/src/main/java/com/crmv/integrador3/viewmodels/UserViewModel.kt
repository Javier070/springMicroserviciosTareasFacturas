package com.crmv.integrador3.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crmv.integrador3.data.UserApi
import com.crmv.integrador3.data.user.User
import com.crmv.integrador3.data.user.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    constructor() : this(UserRepository(UserApi.userService))

    sealed class LoginResult {
        object Success : LoginResult()
        object Error : LoginResult()
    }

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = userRepository.login(username, password)
            if (response.isSuccessful) {
                _loginResult.value = LoginResult.Success
                // Navegar a la vista de detalles del usuario
                val user = response.body()?.users?.get(0) // Suponiendo que solo se devuelve un usuario
                if (user != null) {
                    navigateToUserDetails(user)
                    Log.d("UserViewModel", "Inicio de sesión exitoso: $user")
                } else {
                    Log.e("UserViewModel", "No se pudo obtener el usuario después del inicio de sesión")
                }
            } else {
                _loginResult.value = LoginResult.Error
                Log.e("UserViewModel", "Error en el inicio de sesión: ${response.code()} - ${response.message()}")
            }
        }
    }

    // Navegación después del inicio de sesión exitoso
    private val _navigateToUserDetails = MutableLiveData<User>()
    val navigateToUserDetails: LiveData<User> = _navigateToUserDetails

    private fun navigateToUserDetails(user: User) {
        _navigateToUserDetails.value = user
    }

    //REGISTRO

    sealed class UserResult {
        object Success : UserResult()
        object Error : UserResult()
    }

    private val _userResult = MutableLiveData<UserResult>()
    val userResult: LiveData<UserResult> = _userResult

    fun register(username: String, firstName: String, lastName: String, dni: String, password: String, phone: String, email: String, address: String) {
        viewModelScope.launch {
            val user = User(username, firstName, lastName, dni, password, phone, email, address)
            val response = userRepository.register(user)
            if (response.isSuccessful) {
                _userResult.value = UserResult.Success
            } else {
                _userResult.value = UserResult.Error
            }
        }
    }
}
