package com.faircorp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText


class MainActivity :  BasicActivity() {
    val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the button */
    fun openWindow(view: View) {
        val windowName = findViewById<EditText>(R.id.main_window_name).text.toString().toLong()
        // Do something in response to button
        val intent = Intent(this, WindowActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, windowName)
        }
        startActivity(intent)
    }
}