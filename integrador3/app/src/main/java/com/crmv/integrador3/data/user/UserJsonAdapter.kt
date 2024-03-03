package com.crmv.integrador3.data.user

import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.io.IOException

class UserJsonAdapter {

    @Throws(IOException::class)
    fun fromJson(reader: JsonReader): User? {
        // Implementa la lógica para leer JSON y crear una instancia de User
        return null // Retorna la instancia de User creada a partir del JSON
    }

    @Throws(IOException::class)
    fun toJson(writer: JsonWriter, value: User?) {
        // Implementa la lógica para escribir una instancia de User como JSON
    }
}