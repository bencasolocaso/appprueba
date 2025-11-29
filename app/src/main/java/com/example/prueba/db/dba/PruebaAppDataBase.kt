package com.example.prueba.db.dba

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prueba.db.dao.UserDao
import com.example.prueba.model.Usuario

@Database(entities = [Usuario::class], version = 11)
abstract class PruebaAppDataBase(): RoomDatabase(){
    abstract fun userdao(): UserDao
}