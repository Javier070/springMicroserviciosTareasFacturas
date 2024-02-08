package com.crmv.integrador2.data

data class PokemonResponse(
    var codigo: String,
    val id: Int,
    val abilities: Array<String> = arrayOf()

)
