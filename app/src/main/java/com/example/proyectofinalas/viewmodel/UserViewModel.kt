package com.example.proyectofinalas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalas.data.AppDatabase
import com.example.proyectofinalas.data.Usuario
import com.example.proyectofinalas.repositorio.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun insert(user: Usuario) {
        viewModelScope.launch { repository.insert(user) }
    }

    fun login(email: String, password: String, onResult: (Usuario?) -> Unit) {
        viewModelScope.launch {
            val user = repository.login(email, password)
            onResult(user)
        }
    }
}