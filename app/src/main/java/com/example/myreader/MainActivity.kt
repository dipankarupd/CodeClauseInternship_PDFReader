package com.example.myreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var start_button: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button = findViewById(R.id.start_button)
        start_button.setOnClickListener {

            val intent = Intent(this@MainActivity, PdfActivity::class.java)
            startActivity(intent)
        }
    }
}