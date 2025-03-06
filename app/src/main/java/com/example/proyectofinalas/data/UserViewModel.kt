package com.example.proyectofinalas.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalas.repositorio.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).usuarioDao()
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