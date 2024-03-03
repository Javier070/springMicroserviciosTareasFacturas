package com.crmv.integrador3.data.proyecto

import com.crmv.integrador3.data.user.User

class Proyecto(
    val descripcion: String,
val estado: Boolean,
val fecha_esperada: Any,
val fecha_final: Any,
val id: Int,
val nombre: String,
val tareas: List<Any>,
val user: User
)
