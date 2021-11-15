package com.faircorp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView


const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"

class WindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val param = intent.getStringExtra(WINDOW_NAME_PARAM)
        val windowName = findViewById<TextView>(R.id.txt_window_name)
        windowName.text = param
    }


}

