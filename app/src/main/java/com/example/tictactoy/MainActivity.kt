package com.example.tictactoy


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image.translationY = -1500f
        textView.translationY = 1500f
        image.animate().translationY(0f).duration = 2000
        textView.animate().translationY(0f).duration = 2000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, startactivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                com.google.android.material.R.anim.abc_slide_in_bottom,
                com.google.android.material.R.anim.abc_slide_out_top
            )

        }, 2500)
    }


}

