package com.example.widgetfamoussay

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.widgetfamoussay.ui.theme.WidgetFamousSayTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WidgetFamousSayTheme {
                // A surface container using the 'background' color from the theme
                Main()
            }
        }
        window.statusBarColor = android.graphics.Color.BLACK
    }
}

@Composable
fun Main() {
    val items: MutableList<String> = mutableListOf()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp),
        ) {
            MyAppBar(title = "위젯 명언")
            Spacer(modifier = Modifier.height(24.dp))
            FamousSayList()
        }
    }
}

@Composable
fun MyAppBar(title: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 30.sp, fontWeight = FontWeight.Bold)
//        IconButton(onClick = {
//            Toast.makeText(context,"click!", Toast.LENGTH_LONG).show()
//        }) {
//            Icon(Icons.Filled.FavoriteBorder, "fav")
//        }
    }
}

@Composable
fun FamousSayList() {
    LazyColumn(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))) {
        items(100){ index ->
            Card()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun Card() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 20.dp)) {
            Text(text = "사람을 잘 부리기 위해서는 먼저 공손한 태도를 취하라.", fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 28.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "공자", textAlign = TextAlign.Right, modifier = Modifier.fillMaxWidth(), fontSize = 14.sp,
                color = Color(0xFF71717A)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WidgetFamousSayTheme {
        Main()
    }
}