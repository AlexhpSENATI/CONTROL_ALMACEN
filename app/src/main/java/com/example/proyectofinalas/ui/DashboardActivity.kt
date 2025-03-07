package com.example.proyectofinalas.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinalas.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val userName = intent.getStringExtra("USER_NAME")
        val welcomeTextView = findViewById<TextView>(R.id.tvBienvenido)

        welcomeTextView.text = "Bienvenido, $userName!"
    }
}