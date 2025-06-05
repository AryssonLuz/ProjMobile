package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Tela5 : AppCompatActivity() {

    private lateinit var db: DBHelper
    private lateinit var editId: EditText
    private lateinit var editNome: EditText
    private lateinit var editIdade: EditText
    private lateinit var editTelefone: EditText
    private lateinit var listaView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela5)

        db = DBHelper(this)

        editId = findViewById(R.id.editId)
        editNome = findViewById(R.id.editNome)
        editIdade = findViewById(R.id.editIdade)
        editTelefone = findViewById(R.id.editTelefone)
        listaView = findViewById(R.id.listaView)

        findViewById<Button>(R.id.btnSalvar).setOnClickListener {
            val nome = editNome.text.toString()
            val idade = editIdade.text.toString().toIntOrNull()
            val telefone = editTelefone.text.toString()
            if (nome.isNotBlank() && idade != null && telefone.isNotBlank()) {
                db.inserir(nome, idade, telefone)
                Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                limparCampos()
            }
        }

        findViewById<Button>(R.id.btnListar).setOnClickListener {
            val dados = db.listar()
            listaView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)
        }

        findViewById<Button>(R.id.btnAtualizar).setOnClickListener {
            val id = editId.text.toString().toIntOrNull()
            val nome = editNome.text.toString()
            val idade = editIdade.text.toString().toIntOrNull()
            val telefone = editTelefone.text.toString()
            if (id != null && nome.isNotBlank() && idade != null && telefone.isNotBlank()) {
                if (db.atualizar(id, nome, idade, telefone)) {
                    Toast.makeText(this, "Atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                    limparCampos()
                } else {
                    Toast.makeText(this, "ID não encontrado", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<Button>(R.id.btnExcluir).setOnClickListener {
            val id = editId.text.toString().toIntOrNull()
            if (id != null) {
                if (db.excluir(id)) {
                    Toast.makeText(this, "Excluído com sucesso!", Toast.LENGTH_SHORT).show()
                    limparCampos()
                } else {
                    Toast.makeText(this, "ID não encontrado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun limparCampos() {
        editId.text.clear()
        editNome.text.clear()
        editIdade.text.clear()
        editTelefone.text.clear()
    }
}
