package com.crmv.integrador3.data.user

data class RegisterRequest(
    var username: String,
    var firstName: String,
    var lastName: String,
    var dni: String,
    var password: String,
    var phone: String,
    var email: String,
    var address: String
)

