package com.crmv.integrador3.data.user

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit

class UserRepository(private val userService: UserService) {
    suspend fun login(username: String, password: String): Response<UserResponse> {
        return withContext(Dispatchers.IO) {
            val loginRequest = LoginRequest(username, password)
            userService.login(loginRequest)
        }
    }

    suspend fun register(user: User): Response<UserResponse> {
        return withContext(Dispatchers.IO) {
            val registerRequest = RegisterRequest(
                user.username,
                user.firstName,
                user.lastName,
                user.dni,
                user.password,
                user.phone,
                user.email,
                user.address
            )
            userService.register(registerRequest)
        }
    }
}
