package com.example.fc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardSetActivity : AppCompatActivity() {

    private var cardSetList = mutableListOf<FlashCard>() //Here is the list that contains all of the created set of cards that will display on the home screen (activity_main).
    private val adapter = FlashCardAdapter(cardSetList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_page_layout)

        // Set the TextView to the name of the clicked set.
        val tvSetName = findViewById<TextView>(R.id.tvSetName)
        tvSetName.text = intent.getStringExtra("SET_NAME_SESSION_ID") // Session ID from MainActivity

        val rvSetScreen: RecyclerView = findViewById(R.id.rv_setLayout)
        rvSetScreen.adapter = adapter
        rvSetScreen.layoutManager = LinearLayoutManager(this)


        val floatingAB = findViewById<FloatingActionButton>(R.id.faButton2)
        floatingAB.setOnClickListener {
            cardSetList.add(FlashCard(1))
            adapter.notifyItemInserted(cardSetList.size -1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO code me!
    }
}