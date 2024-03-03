package com.crmv.integrador3.data.proyecto

import retrofit2.Response
import retrofit2.http.GET




interface ProyectoService {
    @GET("proyecto/proyectosPorUsuario/11")
    suspend fun getProyectos(): Response<List<Proyecto>>
}

