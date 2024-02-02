package com.crmv.integrador2.data

import retrofit2.Response
import retrofit2.http.GET

interface FilmApiClient {

    @GET("films/-Mk8-Ge1Bs8EgrWMM4uV.json")
    suspend fun getNewFilms(): Response<List<FilmRemote>>
}