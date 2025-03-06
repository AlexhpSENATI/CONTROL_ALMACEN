package com.example.proyectofinalas.repositorio

import com.example.proyectofinalas.data.Usuario
import com.example.proyectofinalas.data.UsuarioDao

class UserRepository(private val userDao: UsuarioDao) {
    suspend fun insert(user: Usuario) = userDao.insert(user)
    suspend fun login(email: String, password: String) = userDao.login(email, password)
}