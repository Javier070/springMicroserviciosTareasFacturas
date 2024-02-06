package com.crmv.integrador2.data

import retrofit2.Response
import retrofit2.http.GET

interface FilmApiClient {

    @GET("/ditto")
    suspend fun getPokemon(): FilmRemote
}