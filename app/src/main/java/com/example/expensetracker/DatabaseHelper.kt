package com.example.expensetracker

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        val createUsersTable = """
            CREATE TABLE users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                email TEXT,
                password TEXT
            )
        """.trimIndent()

        db.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "ExpenseTracker.db"
        private const val DATABASE_VERSION = 1
    }

    fun insertUser(name: String,email: String,password: String):Boolean{
        val db = this.writableDatabase

        val insertQuery = """
            INSERT INTO users (name,email,password)
            VALUES('$name','$email','$password')
        """.trimIndent()

        db.execSQL(insertQuery)
        db.close()

        return true
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase

        val query = """
        SELECT * FROM users
        WHERE email = ? AND password = ?
    """.trimIndent()

        val cursor = db.rawQuery(query, arrayOf(email, password))
        val exists = cursor.count > 0

        cursor.close()
        db.close()

        return exists
    }

}
