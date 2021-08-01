package com.w4eret1ckrtb1tch.app30

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity_30_4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_30_4)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val recyclerAdapter =
            RecyclerAdapter(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
        recyclerView.adapter = recyclerAdapter

    }
}