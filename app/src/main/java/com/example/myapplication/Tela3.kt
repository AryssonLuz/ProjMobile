package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela3 : AppCompatActivity() {

    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var botaoCalculadora: Button
    private lateinit var resultado: TextView
    private lateinit var botaoResultado: Button
    private var primeiraVez = true
    private lateinit var botaoTela4: Button
    private lateinit var indignacao: TextView


    private fun limitarParaUm(editText: EditText) {
        editText.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            if (source == "1") source else ""
        })
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        numero1 = findViewById(R.id.primeiroNumero)
        numero2 = findViewById(R.id.segundoNumero)
        botaoCalculadora = findViewById(R.id.button5)
        resultado = findViewById(R.id.resultadoTexto)
        botaoResultado = findViewById(R.id.button6)
        botaoTela4 = findViewById(R.id.button7)
        indignacao= findViewById(R.id.text4)


        limitarParaUm(numero1)
        limitarParaUm(numero2)

        botaoCalculadora.setOnClickListener {
            numero1.visibility = View.VISIBLE
            numero2.visibility = View.VISIBLE
            botaoResultado.visibility = View.VISIBLE
        }

        botaoResultado.setOnClickListener {
            // Pegando os textos digitados
            val valor1 = numero1.text.toString()
            val valor2 = numero2.text.toString()

            // Verifica se as caixas não estão vazias
            if (valor1.isNotEmpty() && valor2.isNotEmpty()) {
                // Converte para Int e calcula a soma
                var soma = valor1.toInt() + valor2.toInt()

                if (primeiraVez) {
                    soma += 1
                    primeiraVez = false // depois da primeira vez, volta ao normal
                }

                // Mostra o resultado
                resultado.text = "Resultado: $soma"

                indignacao.visibility = View.VISIBLE

                botaoResultado.setOnClickListener {
                    botaoTela4.visibility = View.VISIBLE
                    val btn = findViewById<Button>(R.id.button7)
                    btn.setOnClickListener {
                        val intent = Intent(this, Tela4::class.java)
                        startActivity(intent)
                    }
                }


            } else {
                // Mostra mensagem se estiver faltando número
                Toast.makeText(this, "Use a cabeça e clique nos malditos numeros 1!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}