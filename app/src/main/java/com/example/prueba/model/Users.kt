package com.example.prueba.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "correo")
    val correo: String,
    @ColumnInfo(name = "contrasena")
    val contrasena: String,
    @ColumnInfo(name = "direccion")
    val direccion: String,
    @ColumnInfo(name = "paises")
    val paises: String
)

