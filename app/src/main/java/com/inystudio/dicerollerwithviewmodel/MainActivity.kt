package com.inystudio.dicerollerwithviewmodel

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var dice: ImageButton
    //private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            viewModel.diceResult = savedInstanceState.getInt(viewModel.diceResultName)

        dice = findViewById(R.id.dice_img)
        //btn = findViewById(R.id.roll_btn)

        dice.setOnClickListener {
            rollDice()
        }
       handleDiceImage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(viewModel.diceResultName, viewModel.diceResult)
    }


    private fun rollDice() {



        val sides: IntRange = 1..6
        val rollResult = sides.random()
        when (rollResult) {
            1 -> dice.setImageResource(R.drawable.dice_1)
            2 -> dice.setImageResource(R.drawable.dice_2)
            3 -> dice.setImageResource(R.drawable.dice_3)
            4 -> dice.setImageResource(R.drawable.dice_4)
            5 -> dice.setImageResource(R.drawable.dice_5)
            else -> dice.setImageResource(R.drawable.dice_6)
        }

        viewModel.diceResult = rollResult
    }


    private fun handleDiceImage() {
        when (viewModel.diceResult) {
            1 -> dice.setImageResource(R.drawable.dice_1)
            2 -> dice.setImageResource(R.drawable.dice_2)
            3 -> dice.setImageResource(R.drawable.dice_3)
            4 -> dice.setImageResource(R.drawable.dice_4)
            5 -> dice.setImageResource(R.drawable.dice_5)
            else -> dice.setImageResource(R.drawable.dice_6)
        }
    }

}
