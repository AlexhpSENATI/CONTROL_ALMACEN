package com.example.proyectofinalas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tuproyecto.databinding.ActivityLoginBinding
import com.example.tuproyecto.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            userViewModel.loginUser(email, password).let { user ->
                if (user != null) {
                    Toast.makeText(this, "Bienvenido ${user.nombre}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}