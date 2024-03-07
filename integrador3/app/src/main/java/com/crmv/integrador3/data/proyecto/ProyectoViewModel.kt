package com.crmv.integrador3.data.proyecto


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProyectoViewModel(private val proyectoRepository: ProyectoRepository) : ViewModel() {

    constructor() : this(ProyectoRepository(ProyectoApi.proyectoService))

    private val _proyectos = MutableLiveData<List<Proyecto>>()
    val proyectos: LiveData<List<Proyecto>> = _proyectos

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getProyectos() {
        viewModelScope.launch {
            try {
                val response = proyectoRepository.getProyectos()
                if (response.isSuccessful) {
                    // Asignar directamente la lista de proyectos al MutableLiveData
                    _proyectos.value = response.body() ?: emptyList()
                } else {
                    _error.value = "Error al obtener los proyectos: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Error al obtener los proyectos: ${e.message}"
            }
        }
    }
}
