package com.example.jetpackcomposetutorial.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment =Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navHostController.navigate(Screen.Detail.route)
            },
            text="First Screen",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(navHostController = rememberNavController())
}