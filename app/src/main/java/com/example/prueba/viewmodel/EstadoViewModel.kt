package com.example.prueba.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.repository.EstadoDataStore
import kotlinx.coroutines.delay

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

abstract class EstadoViewModel (application: Application): AndroidViewModel(application){
    private val estadoDataStore = EstadoDataStore(application)
    private val _activo = MutableStateFlow<Boolean?>(false)
    val activo: StateFlow<Boolean?> = _activo

    private val _mostrar_mensaje= MutableStateFlow<Boolean?>(false)
    val mostrar_mensaje : StateFlow<Boolean?> = _mostrar_mensaje

            init{
                cargarEstado()
            }
    fun cargarEstado(){
        viewModelScope.launch {
            _activo.value=estadoDataStore.obtenerEstado().first()?:false
        }
    }
    fun alternarEstados(){
        viewModelScope.launch {
            val nuevoValor= !(_activo.value ?:false)

            estadoDataStore.guardarEstado((nuevoValor))

            _activo.value = nuevoValor

            _mostrar_mensaje.value = true

            delay(2000)
            _mostrar_mensaje.value =false
        }
    }
}