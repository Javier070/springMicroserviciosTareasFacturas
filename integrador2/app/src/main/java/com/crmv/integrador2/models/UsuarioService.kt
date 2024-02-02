package com.crmv.integrador2.models

import com.crmv.integrador2.data.FilmApiClient
import com.crmv.integrador2.data.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsuarioService {

   /* private val retrofit = RetrofitBuilder.build()

    suspend fun get(): List<Usuario> {
        return  withContext(Dispatchers.IO) {
            val response = retrofit.create(FilmApiClient::class.java).getNewFilms()
            response.body() ?: emptyList()
        }
    }*/
}