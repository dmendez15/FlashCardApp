package com.example.fc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val prefEditor = sharedPref.edit()

        var cardSetList = mutableListOf<CardSet>()

        val adapter = CardSetAdapter(cardSetList)
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
}