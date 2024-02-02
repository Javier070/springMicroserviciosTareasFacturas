package com.crmv.integrador2.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun build(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jetpack-course-default-rtdb.firebaseio.com/films/-Mk8-Ge1Bs8EgrWMM4uV.json")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()



}