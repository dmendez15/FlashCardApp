package com.example.fc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNewSetTextDialog() //Called when the floating action button on the home screen is clicked.
    }

    private fun showNewSetTextDialog(){

       val floatingAB = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingAB.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.new_set_layout,null)

            with(builder){
                setTitle("Create new set")
                setPositiveButton("Save"){dialog, which ->
                    //Add new card to home screen
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