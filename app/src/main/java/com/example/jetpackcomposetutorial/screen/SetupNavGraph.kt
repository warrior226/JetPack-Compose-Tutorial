package com.example.jetpackcomposetutorial.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navHostController: NavHostController){

    NavHost(
        navHostController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navHostController)
        }
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navHostController)
        }
    }
}