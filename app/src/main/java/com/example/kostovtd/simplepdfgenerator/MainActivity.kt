package com.example.kostovtd.simplepdfgenerator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEmptyPdf.setOnClickListener {
            Toast.makeText(this@MainActivity, "Empty PDF clicked", Toast.LENGTH_LONG).show()
        }

        buttonPdfWithText.setOnClickListener {
            Toast.makeText(this@MainActivity, "PDF with text clicked", Toast.LENGTH_LONG).show()
        }

        buttonPdfWithImage.setOnClickListener {
            Toast.makeText(this@MainActivity, "PDF with image clicked", Toast.LENGTH_LONG).show()
        }
    }
}