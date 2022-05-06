package com.example.rafaeldias.homewidgets

import android.appwidget.AppWidgetManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class DetailsActivity : AppCompatActivity() {
    var name: TextView? = null
    var content: TextView? = null
    var addToWidget: ImageView? = null
    var added = false

    // Take your steps of food processig as String variables
    // recipie1 and recipie2.
    private val recipie1 = "Step1: Take a Lemon and required no of glasses of water" +
            "Step2: Squeeze out the lemon juice into glasses,stir well" +
            "and put iceCubes before serve"
    private val recipie2 = "Step1: Take a bread and apply some butter on it" +
            "Step2:Put it in the toaster and it is ready"
    var steps = ArrayList<String>()
    var appWidgetManager: AppWidgetManager? = null
    var appWidgetId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // attach xml file for detailsActivity,that will
        // show detail of every food item
        setContentView(R.layout.details_activity)

        // Add Steps into step ArrayList
        steps.add(recipie1)
        steps.add(recipie2)
        addToWidget = findViewById(R.id.addToWidget)

        // AppWidgetManager manages creating and updating
        // the multiple widgets an application can have.
        appWidgetManager = AppWidgetManager.getInstance(
            this@DetailsActivity
        )
        appWidgetId = 1

        // Each AppWidget has a different appWidgetId to
        // make it unique.
        name = findViewById(R.id.name)
        content = findViewById(R.id.steps)
        val heading = intent.getStringExtra("name")
        val pos = intent.getIntExtra("pos", -1)
        recipie = Recipie(heading, steps[pos])
        name.setText(heading)
        content.setText(steps[pos])

        // Attach clickListener on ImageView Object so when
        // we will click it will handle the widget adding
        // code.
        addToWidget.setOnClickListener(
            View.OnClickListener {
                added = !added // boolean variable to
                // know the state ,if
                // widget is added or not.
                Toast
                    .makeText(
                        this@DetailsActivity,
                        "Click",
                        Toast.LENGTH_SHORT
                    )
                    .show()
                if (added) {
                    // Calling updateAppWidget static
                    // method of RecipieWidget to update
                    // widges of app
                    RecipieWidget.updateAppWidget(
                        this@DetailsActivity,
                        appWidgetManager, appWidgetId,
                        recipie
                    )
                    Toast
                        .makeText(
                            this@DetailsActivity,
                            "Added to Widegt",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                    addToWidget.setImageDrawable(
                        resources.getDrawable(
                            R.drawable.ic_android_black_24dp
                        )
                    )
                } else {
                    addToWidget.setImageDrawable(
                        resources.getDrawable(
                            R.drawable.not_widget
                        )
                    )
                    RecipieWidget.updateAppWidget(
                        this@DetailsActivity,
                        appWidgetManager, appWidgetId,
                        null
                    )
                }
            })
    }

    companion object {
        var recipie: Recipie? = null

        // This method was created to pass Recipe object
        // information to AppWidget.
        fun getRecipie(): Recipie? {
            return recipie
        }
    }
}