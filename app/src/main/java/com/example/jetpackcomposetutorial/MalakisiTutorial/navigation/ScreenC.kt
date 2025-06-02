package com.example.jetpackcomposetutorial.MalakisiTutorial.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ScreenC(
    text:String,
    number:Int,
    onNavigateToScreenD:(String,String)->Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "Text is $text")
            Text(text="Number is $number ")
            Button(
                onClick ={
                    onNavigateToScreenD("RAYAISSE","Patrick")
                }
            ) {
                Text(text = "Navigate on Screen D")
            }

        }
    }
}