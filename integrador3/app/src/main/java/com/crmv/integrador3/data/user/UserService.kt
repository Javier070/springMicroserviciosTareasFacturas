package com.crmv.integrador3.data.user

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("user/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<UserResponse>

    @POST("user/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<UserResponse>
}