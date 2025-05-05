package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme
import com.example.jetpackcomposetutorial.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor =Color.White) { innerPadding ->

                    Row(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding),
                        horizontalArrangement = Arrangement.Start,

                        ) {
                        CustomItem(weight = 3f, color = MaterialTheme.colorScheme.secondary)
                        CustomItem(weight = 1f)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!!",
        modifier = modifier
    )
}

@Composable
fun CustomText(text:String){
    Text(
        text =text,
        style= Typography.displaySmall
    )
}

@Composable
fun RowScope.CustomItem(weight:Float, color:Color=MaterialTheme.colorScheme.primary){
    Surface(modifier = Modifier
        .width(200.dp)
        .height(50.dp)
        .weight(weight),
        color = color){

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTutorialTheme {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,

        ) {
            CustomItem(weight = 3f, color = MaterialTheme.colorScheme.secondary)
            CustomItem(weight = 1f)
        }
    }
}