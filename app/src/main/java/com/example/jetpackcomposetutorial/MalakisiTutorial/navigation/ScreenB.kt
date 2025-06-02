package com.example.jetpackcomposetutorial.MalakisiTutorial.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ScreenB(
    onNavigateToScreenC:(String,Int)->Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "ScreenB")
            Button(onClick =
                {
                    onNavigateToScreenC("Text from Screen B",100)
                }) {
                Text(text = "Naviguer vers ScreenC")
            }

        }
    }
}