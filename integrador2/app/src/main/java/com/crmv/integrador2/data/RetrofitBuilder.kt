package com.crmv.integrador2.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun build(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()



}