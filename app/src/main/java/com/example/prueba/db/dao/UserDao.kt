package com.example.prueba.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.prueba.model.Usuario

@Dao
interface UserDao {
    @Query("SELECT * FROM Usuarios")
    fun tenerTodosLosUsuarios(): MutableList<Usuario>

    @Insert
    fun insertarUsuario(usuario: Usuario): Long

    @Query("SELECT * FROM Usuarios WHERE correo = :correo")
    fun obtenerUsuarioPorCorreo(correo: String): Usuario?
    @Query("SELECT * FROM Usuarios WHERE id = :id")
    fun obtenerUsuarioPorId(id: Long): Usuario?
    @Query("SELECT * FROM Usuarios WHERE correo = :correo and contrasena = :contrasena")
    fun obtenerUsuarioPorCredenciales(correo: String, contrasena: String): Usuario?
    @Update
    fun actualizarUsuario(usuario: Usuario)
    @Delete
    fun eliminarUsuario(usuario: Usuario)
}




