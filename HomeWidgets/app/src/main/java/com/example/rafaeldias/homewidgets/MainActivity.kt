package com.example.rafaeldias.homewidgets

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var recipies: ListView? = null
    var addRecipie = arrayOf("Lemonade", "BreadToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Attach your aml file with java file here
        setContentView(R.layout.activity_main)

        // Creating Java object for List of all food items.
        recipies = findViewById(R.id.recipies)

        // Adapter to hold your data of all food items
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            addRecipie
        )
        recipies.setAdapter(adapter)

        // Set a clickListener on each item,so on clicking
        // item an intent will launch.
        recipies.setOnItemClickListener(
            OnItemClickListener { adapterView, view, i, l ->
                val `in` = Intent(
                    this@MainActivity,
                    DetailsActivity::class.java
                )

                // putExtra method allows you to pass
                // data between two activities easily
                `in`.putExtra("name", addRecipie[i])
                `in`.putExtra("pos", i)
                startActivity(`in`)
            })
    }
}