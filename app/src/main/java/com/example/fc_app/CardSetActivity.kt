package com.example.fc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardSetActivity : AppCompatActivity(), FlashCardAdapter.OnItemClickListener {

    private var cardSetList = mutableListOf<FlashCard>() //Here is the list that contains all of the created set of cards that will display on the home screen (activity_main).
    private val adapter = FlashCardAdapter(cardSetList, this)
    private var cardID: Int = 0

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
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.new_card_dialouge_box,null)
            val editTextA = dialogLayout.findViewById<EditText>(R.id.et_SideA)
            val editTextB = dialogLayout.findViewById<EditText>(R.id.et_SideB)

            with(builder){
                setTitle("Create new card")
                setPositiveButton("Save"){dialog, which ->
                    //Add new set to the home screen
                    val textA = editTextA.text.toString() //Get the text the user typed.
                    val textB = editTextB.text.toString()

                    cardSetList.add(FlashCard(textA,textB))
                    adapter.notifyItemInserted(cardSetList.size -1)
                }
                setNegativeButton("Cancel"){dialog, which ->
                    //Cancel
                }
                setView(dialogLayout)
                show()
            }
            //cardSetList.add(FlashCard("", ""))
            //adapter.notifyItemInserted(cardSetList.size -1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO code me!
    }

    override fun onItemClick(position: Int) {

    }
}