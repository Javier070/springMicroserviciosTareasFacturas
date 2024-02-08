package com.crmv.integrador2.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crmv.integrador2.data.PokemonResponse
import com.crmv.integrador2.data.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProyectosViewModel: ViewModel() {

    /*var _listaProyectos: ArrayList<PokemonResponse> by mutableStateOf(arrayListOf())
    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitBuilder.webService.getPokemon()
            withContext(Dispatchers.Main) {
                if (response.body()!!.codigo == "200") {
                    _listaProyectos = response.body()!!.data as ArrayList<PokemonResponse>
                }
            }
        }
    }*/

 /*   fun AddProyectos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getUsuarios()
            withContext(Dispatchers.Main) {
                if (response.body()!!.codigo == "200") {
                    _listaUsuarios = response.body()!!.data
                }
            }
        }
    }

    fun UpdateProyectos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getUsuarios()
            withContext(Dispatchers.Main) {
                if (response.body()!!.codigo == "200") {
                    _listaUsuarios = response.body()!!.data
                }
            }
        }
    }


    fun RemoveProyectos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getUsuarios()
            withContext(Dispatchers.Main) {
                if (response.body()!!.codigo == "200") {
                    _listaUsuarios = response.body()!!.data
                }
            }
        }
    }*/
}