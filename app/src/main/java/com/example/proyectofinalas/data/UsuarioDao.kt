package com.example.proyectofinalas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertarUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE correo = :correo AND contraseña = :contraseña LIMIT 1")
    suspend fun iniciarSesion(correo: String, contraseña: String): Usuario?
}