package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.incrementButton)
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)
        val countTextView = findViewById<TextView>(R.id.userCount)
        button.setOnClickListener {
            count++
            countTextView.text = count.toString()

            if (count >= 100) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "ADD 2"

                    button.setOnClickListener {
                        count += 2
                        countTextView.text = count.toString()
                    }

                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}