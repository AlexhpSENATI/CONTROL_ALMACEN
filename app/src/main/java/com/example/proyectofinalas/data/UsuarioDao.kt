package com.example.proyectofinalas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertUser(usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE email = :email AND password = :password")
    suspend fun queryUser(email: String, password: String): Usuario?

    @Query("SELECT * FROM usuario")
    suspend fun getAllUsers(): List<Usuario>
}
