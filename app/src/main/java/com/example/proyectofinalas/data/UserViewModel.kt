package com.example.proyectofinalas.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalas.repositorio.UserRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val usuarioDao = AppDatabase.getDatabase(application).usuarioDao()
        repository = UserRepository(usuarioDao)
    }

    suspend fun getUser(email: String, password: String): Usuario? {
        return withContext(Dispatchers.IO) {
            repository.getUserByEmailAndPassword(email, password)
        }
    }

    fun insert(user: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }
    }
}
