package com.example.proyectofinalas.repositorio

import com.example.proyectofinalas.data.Usuario
import com.example.proyectofinalas.data.UsuarioDao

class UserRepository(private val usuarioDao: UsuarioDao) {

    suspend fun insert(user: Usuario) {
        usuarioDao.insert(user)
    }

    suspend fun login(email: String, password: String): Usuario? {
        return usuarioDao.login(email, password)
    }
}