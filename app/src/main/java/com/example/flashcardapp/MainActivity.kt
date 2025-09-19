package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>( R.id.flashcard_answer)
        val extra1 = findViewById<TextView>(R.id.flashcard_extra1)
        val extra2 = findViewById<TextView>(R.id.flashcard_extra2)
        val extra3 = findViewById<TextView>(R.id.flashcard_extra3)
        val mybtn = findViewById<ImageView>(R.id.myBtn)

        mybtn.setOnClickListener{
            fun launchComposeView() {
                // first parameter is the context, second is the class of the activity to launch
                val i = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(i) // brings up the second activity
            }
            launchComposeView()
        }


        // Fonksyon pou reinitialiser koulè yo
        fun resetColors() {
            flashcardAnswer.setBackgroundColor(ContextCompat.getColor(this, R.color.my_transparent))
            extra1.setBackgroundColor(ContextCompat.getColor(this, R.color.my_transparent))
            extra2.setBackgroundColor(ContextCompat.getColor(this, R.color.my_transparent))
            extra3.setBackgroundColor(ContextCompat.getColor(this, R.color.my_transparent))
        }

        flashcardAnswer.setOnClickListener {
            resetColors()
            flashcardAnswer.setBackgroundColor(ContextCompat.getColor(this, R.color.my_green_color))
        }

        extra1.setOnClickListener {
            resetColors()
            extra1.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red_color))
        }

        extra2.setOnClickListener {
            resetColors()
            extra2.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red_color))
        }

        extra3.setOnClickListener {
            resetColors()
            extra3.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red_color))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}