package com.crmv.integrador3.data.proyecto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProyectoViewModelFactory(private val proyectoService: ProyectoService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProyectoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProyectoViewModel(ProyectoRepository(proyectoService)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

