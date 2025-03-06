package com.example.proyectofinalas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usurious")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val email: String,
    val password: String
)
