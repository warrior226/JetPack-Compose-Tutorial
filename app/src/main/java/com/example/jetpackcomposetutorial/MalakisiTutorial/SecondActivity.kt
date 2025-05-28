package com.example.jetpackcomposetutorial.MalakisiTutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcomposetutorial.Greeting
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme

class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        "SecondActivity",
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }

    }
}