package com.example.fc_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CardSetAdapter(private val sets: List<CardSet>, private val listener: OnItemClickListener) : RecyclerView.Adapter<CardSetAdapter.CardSetViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card_set, parent, false)

        return CardSetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardSetViewHolder, position: Int) {
        val currentItem = sets[position]

        holder.tvTitle.text = currentItem.title
        holder.tvCardAmt.text = currentItem.cardAmt
    }

    override fun getItemCount() = sets.size

    inner class CardSetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvCardAmt: TextView = itemView.findViewById(R.id.tvCardAmt)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}