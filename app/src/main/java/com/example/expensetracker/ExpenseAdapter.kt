package com.example.expensetracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val expenses: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIcon: TextView = itemView.findViewById(R.id.tvIcon)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]

        holder.tvIcon.text = expense.icon
        holder.tvTitle.text = expense.title
        holder.tvSubtitle.text = expense.subtitle
        holder.tvAmount.text = expense.amount
    }

    override fun getItemCount(): Int = expenses.size
}
