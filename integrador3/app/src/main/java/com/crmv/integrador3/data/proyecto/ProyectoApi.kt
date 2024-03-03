package com.crmv.integrador3.data.proyecto

import com.crmv.integrador3.data.user.UserService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProyectoApi {
    val proyectoService: ProyectoService =
        Retrofit.Builder()
            .baseUrl("http://172.167.157.237:80/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ProyectoService::class.java)
}

