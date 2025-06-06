package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class Tela6 : AppCompatActivity() {

    private lateinit var textoFinal: TextView
    private lateinit var botaoFinal: Button
    private lateinit var imagemFinal: ImageView
    private var primeiroClique = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textoFinal = findViewById(R.id.text7)
        botaoFinal = findViewById(R.id.button10)
        imagemFinal = findViewById(R.id.image2)




        botaoFinal.setOnClickListener {
            // Torna visíveis ao clicar
            imagemFinal.visibility = View.VISIBLE
            textoFinal.visibility = View.VISIBLE

            // Escolhe uma opção aleatória para mostrar
            if (primeiroClique){
                when (Random.nextInt(4)) {
                    0 -> {
                        imagemFinal.setImageResource(R.mipmap.nota10)
                        textoFinal.text = "Nota 10, parabéns!"
                    }
                    1 -> {
                        imagemFinal.setImageResource(R.mipmap.nota0)
                        textoFinal.text = "Nota 0, que pena!"
                    }
                    2 -> {
                        imagemFinal.setImageResource(R.mipmap.nota_do)
                        textoFinal.text = "Nota do, com D de direto pra final!"
                    }
                    3 -> {
                        imagemFinal.setImageResource(R.mipmap.absolute)
                        textoFinal.text = "Melhor trabalho que eu já vi na minha vida!"
                    }
                }
            }
            primeiroClique = true
        }

        }
}