package com.crmv.integrador3.data.user

    data class User(
        val username: String,
        val firstName: String,
        val lastName: String,
        val dni: String,
        val password: String,
        val phone: String,
        val email: String,
        val address: String,
    )
