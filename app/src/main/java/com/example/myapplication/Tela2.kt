package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela2 : AppCompatActivity() {

    private lateinit var imagemPrincipal: ImageView
    private lateinit var mudarImagem: Button
    private var usandoImagemOriginal = true
    private lateinit var botaoTela3: Button
    private lateinit var imagemClicavel: ImageView
    private lateinit var exibirTexto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mudarImagem = findViewById(R.id.button3)
        imagemPrincipal = findViewById(R.id.imageView)
        botaoTela3 = findViewById(R.id.button4)
        imagemClicavel = findViewById(R.id.imageView)
        exibirTexto = findViewById(R.id.text3)


        mudarImagem.setOnClickListener {
            if (usandoImagemOriginal) {
                // Troca para a imagem nova
                imagemPrincipal.setImageResource(R.mipmap.homer)
                usandoImagemOriginal = false
                mudarImagem.text = "Voltar Imagem"
                exibirTexto.text = "Agora clique na imagem"
                exibirTexto.visibility = View.VISIBLE
            } else {
                // Retorna para a imagem original
                imagemPrincipal.setImageResource(R.mipmap.img)
                usandoImagemOriginal = true
                mudarImagem.text = "Trocar Imagem"


            }

            imagemClicavel.setOnClickListener {
                botaoTela3.visibility = View.VISIBLE


                val btn = findViewById<Button>(R.id.button4)
                btn.setOnClickListener {
                    val intent = Intent(this, Tela3::class.java)
                    startActivity(intent)
                }
            }





        }





    }
}
