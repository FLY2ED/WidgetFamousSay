package com.example.widgetfamoussay

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class GreetingsWidget(private val name: String): GlanceAppWidget() {
    @Composable
    override fun Content() {
        Text(text = "Hello $name")
    }
}

class GreetingsWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget = GreetingsWidget("Glance")
}