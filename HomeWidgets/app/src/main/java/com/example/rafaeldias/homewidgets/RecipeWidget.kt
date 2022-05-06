package com.example.rafaeldias.homewidgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.RemoteViews


// Implementation of App Widget functionality.
class RecipeWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update
        // all of them
        for (appWidgetId in appWidgetIds) {
            val recipie: Recipie? = DetailsActivity.getRecipie()
            Log.d(TAG, recipie!!.getName())
            updateAppWidget(
                context, appWidgetManager,
                appWidgetId, recipie
            )
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first
        // widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last
        // widget is disabled
    }

    companion object {
        var TAG = RecipeWidget::class.java.name
        fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int, recipie: Recipie?
        ) {
            // Create RemoteView Object to handle your view of
            // widget
            val views = RemoteViews(
                context.packageName,
                R.layout.recipie_widget
            )
            assert(recipie != null)
            // Set what content you want to display on Widget by
            // providing id of view and corresponding content
            views.setTextViewText(
                R.id.heading_text,
                recipie!!.getName()
            )
            views.setTextViewText(
                R.id.steps_text,
                recipie!!.getSteps()
            )
            appWidgetManager.updateAppWidget(
                appWidgetId,
                views
            )
        }
    }
}