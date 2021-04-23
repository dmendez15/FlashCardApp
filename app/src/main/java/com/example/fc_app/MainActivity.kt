package com.example.fc_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), CardSetAdapter.OnItemClickListener {

    private var cardSetList = mutableListOf<CardSet>() //Here is the list that contains all of the created set of cards that will display on the home screen (activity_main).
    private val adapter = CardSetAdapter(cardSetList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        val rvSetScreen: RecyclerView = findViewById(R.id.rvSetScreen)

        rvSetScreen.adapter = adapter
        rvSetScreen.layoutManager = LinearLayoutManager(this)

        //Dialog that will create a new set of cards.
        //When the floating action button is clicked, create a brand new set.
        val floatingAB = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingAB.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.new_set_dialouge_box,null)
            val editText = dialogLayout.findViewById<EditText>(R.id.et_setName)

            with(builder){
                setTitle("Create new set")
                setPositiveButton("Save"){dialog, which ->
                    //Add new set to the home screen
                    val title = editText.text.toString() //Get the text the user typed.
                    val cardTxt = "Card Amount: 0"

                    val set = CardSet(title, cardTxt)
                    cardSetList.add(set)
                    adapter.notifyItemInserted(cardSetList.size -1)
                }
                setNegativeButton("Cancel"){dialog, which ->
                    //Cancel
                }
                setView(dialogLayout)
                show()
            }
        }
    }

    //When a certain set is clicked this will do something.
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: CardSet = cardSetList[position]
        launchCardSetActivity(position)
    }

    private fun launchCardSetActivity(position: Int){
        val intent = Intent(this, CardSetActivity::class.java)
        intent.putExtra("SET_NAME_SESSION_ID", cardSetList[position].title) // Used to pass the flashcard set name to the CardSetActivity.
        startActivity(intent)
    }
}