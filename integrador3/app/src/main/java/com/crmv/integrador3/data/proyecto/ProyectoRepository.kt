package com.crmv.integrador3.data.proyecto

import com.crmv.integrador3.data.user.UserService
import retrofit2.Response

class ProyectoRepository(private val proyectoService: ProyectoService) {
    suspend fun getProyectos(): Response<List<Proyecto>> {
        return proyectoService.getProyectos()
    }
}

