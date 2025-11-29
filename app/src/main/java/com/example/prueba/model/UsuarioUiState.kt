package com.example.prueba.model

data class UsuarioUiState(
    val nombre: String="",
    val correo: String="",
    val contrasena: String="",
    val direccion: String="",
    val aceptaTerminos: Boolean=false,
    val errores: UsuarioErrores= UsuarioErrores(),
    val paises: String=""

)

data class UsuarioErrores(
    val nombre: String?=null,
    val correo: String?=null,
    val contrasena: String?=null,
    val direccion: String? =null,
    val paises: String?=null

)