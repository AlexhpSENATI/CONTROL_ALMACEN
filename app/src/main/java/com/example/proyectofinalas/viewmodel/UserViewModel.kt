package com.example.proyectofinalas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuproyecto.data.AppDatabase
import com.example.tuproyecto.data.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    fun registerUser(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.login(email, password)
    }
}