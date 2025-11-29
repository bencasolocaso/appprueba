package com.example.prueba.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prueba.db.dao.UserDao
import com.example.prueba.model.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
