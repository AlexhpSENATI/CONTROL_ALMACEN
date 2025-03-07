package com.example.proyectofinalas.repositorio

import android.util.Log
import com.example.proyectofinalas.data.Usuario
import com.example.proyectofinalas.data.UsuarioDao

class UserRepository(private val usuarioDao: UsuarioDao) {

    suspend fun insertUser(user: Usuario) {
        usuarioDao.insertUser(user)
    }

    suspend fun getUserByEmailAndPassword(email: String, password: String): Usuario? {
        return usuarioDao.queryUser(email, password)
    }

    suspend fun getAllUsers(): List<Usuario> {
        return usuarioDao.getAllUsers()
    }
}
