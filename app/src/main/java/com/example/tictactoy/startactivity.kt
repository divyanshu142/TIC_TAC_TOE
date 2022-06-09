package com.example.tictactoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_startactivity.*

class startactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity)

        buttonply.setOnClickListener {
            val intent = Intent(this, playgame::class.java)
            startActivity(intent)
            overridePendingTransition(
                com.google.android.material.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_slide_out_top
            )
        }
    }


}