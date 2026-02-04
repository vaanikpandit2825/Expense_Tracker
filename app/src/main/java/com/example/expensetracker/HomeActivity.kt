package com.example.expensetracker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val rvExpenses = findViewById<RecyclerView>(R.id.rvExpenses)

        val expenseList = listOf(
            Expense("Food & Drink", "Lunch at cafe", "- ₹120", "🍔"),
            Expense("Transport", "Bus pass", "- ₹50", "🚌"),
            Expense("Shopping", "Online order", "- ₹300", "🛍️")
        )

        rvExpenses.layoutManager = LinearLayoutManager(this)
        rvExpenses.adapter = ExpenseAdapter(expenseList)


    }
}