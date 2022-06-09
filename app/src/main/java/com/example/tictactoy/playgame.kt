package com.example.tictactoy

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import kotlinx.android.synthetic.main.dilogsmakes.*


class playgame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playgame)
    }

    var winer = -1
    fun buclick(view: View) {

        var cellid = 0
        val buselected = view as Button

        when (buselected.id) {
            R.id.bu1 ->
                cellid = 1
            R.id.bu2 ->
                cellid = 2
            R.id.bu3 ->
                cellid = 3
            R.id.bu4 ->
                cellid = 4
            R.id.bu5 ->
                cellid = 5
            R.id.bu6 ->
                cellid = 6
            R.id.bu7 ->
                cellid = 7
            R.id.bu8 ->
                cellid = 8
            R.id.bu9 ->
                cellid = 9
        }
        playgame(cellid, buselected)
    }

    var currentplay = 1
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    var emptyCells = ArrayList<Int>()
    fun playgame(cellid: Int, buselected: Button) {

        if (currentplay == 1) {
            buselected.text = "X"
            buselected.setBackgroundResource(R.drawable.dilogedigen1)
            player1.add(cellid)
            emptyCells.add(cellid)
            currentplay = 2
        } else {
            buselected.text = "0"
            buselected.setBackgroundResource(R.drawable.dilogedigen2)
            player2.add(cellid)
            emptyCells.add(cellid)
            currentplay = 1
        }
        buselected.isEnabled = false

        plyerwiner()
    }


    fun plyerwiner() {

        //var winer = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }

        if (winer == 1) {

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dilogsmakes)
            dialog.winner.text = "Player 1 Win The Game"
            dialog.exit.setOnClickListener {
                finishAffinity()

            }
            dialog.playagain.setOnClickListener {
                val intent = Intent(this, playgame::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        } else if (winer == 2) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dilogsmakes)
            dialog.winner.text = "Player 2 Win The Game"
            dialog.exit.setOnClickListener {

                finishAffinity()
            }
            dialog.playagain.setOnClickListener {
                val intent = Intent(this, playgame::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        } else if (player1.size == 5 && player2.size == 4) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dilogsmakes)
            dialog.winner.text = "Game Has Draw"
            dialog.exit.setOnClickListener {

                finishAffinity()
            }
            dialog.playagain.setOnClickListener {
                val intent = Intent(this, playgame::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        }

    }
}

