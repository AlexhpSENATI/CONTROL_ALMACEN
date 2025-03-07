package com.example.proyectofinalas.ui
import kotlinx.coroutines.launch
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
import androidx.lifecycle.lifecycleScope
class RegisterActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val nombreEditText = findViewById<EditText>(R.id.etNombre)
        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val registerButton = findViewById<Button>(R.id.rbutton)

        registerButton.setOnClickListener {
            val nombre = nombreEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = Usuario(nombre = nombre, email = email, password = password)

                lifecycleScope.launch {
                    viewModel.insert(user)
                    runOnUiThread {
                        Toast.makeText(this@RegisterActivity, "Usuario registrado", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

