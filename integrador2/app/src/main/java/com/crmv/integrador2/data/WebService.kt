package com.crmv.integrador2.data

import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("/ditto")
    suspend fun getPokemon(): Response<PokemonResponse>
}