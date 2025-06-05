package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Tela4 : AppCompatActivity() {

    private lateinit var botaoBanco: Button
    private lateinit var imagem1: ImageView
    private lateinit var imagem2: ImageView
    private lateinit var imagem3: ImageView
    private lateinit var botao1: Button
    private lateinit var botao2: Button
    private lateinit var botao3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela4)

        imagem1 = findViewById(R.id.dados1)
        imagem2 = findViewById(R.id.dados2)
        imagem3 = findViewById(R.id.dados3)

        botaoBanco = findViewById(R.id.button8)
        botao1 = findViewById(R.id.botaoBrincadeira1)
        botao2 = findViewById(R.id.botaoBrincadeira2)
        botao3 = findViewById(R.id.botaoBrincadeira3)

        botaoBanco.setOnClickListener {
            imagem1.visibility = View.VISIBLE
            botao1.visibility = View.VISIBLE
            botaoBanco.visibility = View.GONE
        }

        botao1.setOnClickListener {
            imagem2.visibility = View.VISIBLE
            botao2.visibility = View.VISIBLE
            botao1.visibility = View.GONE
        }

        botao2.setOnClickListener {
            imagem3.visibility = View.VISIBLE
            botao3.visibility = View.VISIBLE
            botao2.visibility = View.GONE
        }

        botao3.setOnClickListener {
            // Atualiza o texto do botão
            botao3.text = "🚀 Agora sim, bora pra prática!"

            // Inicia a próxima tela (Tela5)
            val intent = Intent(this@Tela4, Tela5::class.java)
            startActivity(intent)
        }
    }
}
