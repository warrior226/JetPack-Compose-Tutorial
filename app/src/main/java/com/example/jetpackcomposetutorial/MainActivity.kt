package com.example.jetpackcomposetutorial

import android.icu.text.DisplayContext
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor =MaterialTheme.colorScheme.primary) { innerPadding ->

                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        CustomText(text = "I am learning JetPack Compose")

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTutorialTheme {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            Surface(modifier = Modifier
                .width(200.dp)
                .weight(3f),
                color = MaterialTheme.colorScheme.secondary) {
                Column {

                }
            }
            Surface(modifier = Modifier
                .width(200.dp)
                .weight(5f),
                color = MaterialTheme.colorScheme.primary) {
                Column {

                }
            }
        }
    }
}