package com.example.fc_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardSetAdapter(
        var sets: List<CardSet>
) : RecyclerView.Adapter<CardSetAdapter.CardSetViewHolder>() {

    inner class CardSetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_set, parent, false)
        return CardSetViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardSetViewHolder, position: Int) {
        holder.itemView.apply{
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            val tvCardAmt = findViewById<TextView>(R.id.tvCardAmt)
            tvTitle.text = sets[position].title
            tvCardAmt.text = sets[position].cardAmt.toString()
        }
    }

    override fun getItemCount(): Int {
        return sets.size
    }
}