package com.example.proyectofinalas.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinalas.R
import com.example.proyectofinalas.data.Usuario
import com.example.proyectofinalas.data.UserViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        findViewById<Button>(R.id.rbutton).setOnClickListener {
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = Usuario(nombre = nombre, email = email, password = password)

                viewModel.insert(user)

                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

