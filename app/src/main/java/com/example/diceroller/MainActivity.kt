package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the results
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(R.id.imageView)
            rollDice(R.id.imageView2)
        }
    }

    /**
     * Roll the dice and update the screen with the results
     */
    private fun rollDice(imageViewId: Int) {
        // Create a new dice with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll image
        val diceImage: ImageView = findViewById(imageViewId)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dice class is the blueprint for the Dice object
 * One can set the number of sides and roll it
 */
class Dice(private val numSides: Int) {

    /**
     * roll, rolls the dice to get a side
     */
    fun roll(): Int {
        // The range is the number of sides
        return (1..numSides).random()
    }
}