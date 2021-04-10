package com.example.fc_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FlashCardAdapter(private val sets: List<FlashCard>, cardSetActivity: CardSetActivity) : RecyclerView.Adapter<FlashCardAdapter.FlashCardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashCardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.flash_card, parent, false)

        return FlashCardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashCardViewHolder, position: Int) {
        
    }

    override fun getItemCount() = sets.size

    inner class FlashCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}