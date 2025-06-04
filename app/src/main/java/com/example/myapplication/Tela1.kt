package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela1 : AppCompatActivity() {

    private lateinit var botaoMostrar: Button
    private lateinit var textoExibido: TextView
    private lateinit var botaoExibir: Button
    private lateinit var botaoTela2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        botaoMostrar = findViewById(R.id.button)
        textoExibido = findViewById(R.id.text2)

        botaoExibir = findViewById(R.id.button)
        botaoTela2 = findViewById(R.id.button2)


        botaoMostrar.setOnClickListener {
            textoExibido.text = "No caso clique de novo para aparecer o botão certo kkkkkkkkkkkkk"
            textoExibido.visibility = View.VISIBLE

            botaoExibir.setOnClickListener {
                botaoTela2.visibility = View.VISIBLE


            }

            val btn = findViewById<Button>(R.id.button2)
            btn.setOnClickListener {
                val intent = Intent(this, Tela2::class.java)
                startActivity(intent)
            }
        }
}
}