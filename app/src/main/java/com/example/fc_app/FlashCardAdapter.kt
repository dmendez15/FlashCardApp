package com.example.fc_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FlashCardAdapter(private val sets: List<FlashCard>, private val listener: OnItemClickListener) : RecyclerView.Adapter<FlashCardAdapter.FlashCardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashCardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.flash_card, parent, false)

        return FlashCardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashCardViewHolder, position: Int) {
        val currentItem = sets[position]

        holder.tvFacingSide.text = currentItem.sideA
    }

    override fun getItemCount() = sets.size

    inner class FlashCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvFacingSide: TextView = itemView.findViewById(R.id.tvFacingSide)
        var flipped: Boolean = true

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val currentItem = sets[position]
            if (position != RecyclerView.NO_POSITION){
                if (flipped){
                    tvFacingSide.text = currentItem.sideB
                    flipped = false
                }
                else{
                    tvFacingSide.text = currentItem.sideA
                    flipped = true
                }

                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}