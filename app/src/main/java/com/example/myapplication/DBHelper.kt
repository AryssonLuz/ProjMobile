package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "PessoaDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE Pessoa(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER, telefone TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Pessoa")
        onCreate(db)
    }

    fun inserir(nome: String, idade: Int, telefone: String): Boolean {
        val db = writableDatabase
        val valores = ContentValues().apply {
            put("nome", nome)
            put("idade", idade)
            put("telefone", telefone)
        }
        return db.insert("Pessoa", null, valores) != -1L
    }

    fun listar(): List<String> {
        val lista = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Pessoa", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
                val idade = cursor.getInt(cursor.getColumnIndexOrThrow("idade"))
                val telefone = cursor.getString(cursor.getColumnIndexOrThrow("telefone"))
                lista.add("ID: $id - $nome, $idade anos, Tel: $telefone")
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }

    fun atualizar(id: Int, nome: String, idade: Int, telefone: String): Boolean {
        val db = writableDatabase
        val valores = ContentValues().apply {
            put("nome", nome)
            put("idade", idade)
            put("telefone", telefone)
        }
        val linhasAfetadas = db.update("Pessoa", valores, "id = ?", arrayOf(id.toString()))
        return linhasAfetadas > 0
    }

    fun excluir(id: Int): Boolean {
        val db = writableDatabase
        val linhasAfetadas = db.delete("Pessoa", "id = ?", arrayOf(id.toString()))
        return linhasAfetadas > 0
    }
}
