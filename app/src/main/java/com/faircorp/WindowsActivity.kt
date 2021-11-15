package com.faircorp

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.faircorp.model.OnWindowSelectedListener
import com.faircorp.model.WindowAdapter

import com.faircorp.model.WindowService

//const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"

class WindowsActivity :  BasicActivity(), OnWindowSelectedListener {

    val windowService = WindowService() // (1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)

        val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
        val adapter = WindowAdapter(this) // (3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        adapter.update(windowService.findAll()) // (4)
    }


    override fun onWindowSelected(id: Long) {

        //Toast.makeText(this, "You clicked on ${id}", Toast.LENGTH_LONG).show()

        val intent = Intent(this, WindowActivity::class.java).putExtra(WINDOW_NAME_PARAM, id)
        startActivity(intent)
    }

}
