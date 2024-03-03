package com.crmv.integrador3.data

import com.crmv.integrador3.data.user.UserService
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object UserApi {


    val userService: UserService =
        Retrofit.Builder()
        .baseUrl("http://172.167.157.237:80/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(UserService::class.java)
}
