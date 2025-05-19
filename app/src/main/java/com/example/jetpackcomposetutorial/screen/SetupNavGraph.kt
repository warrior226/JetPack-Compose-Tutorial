package com.example.jetpackcomposetutorial.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navHostController: NavHostController){

    NavHost(
        navHostController,
        startDestination = Screen.AuthScreen.route
    ){
        composable(
            route = Screen.Home.route,
            arguments= listOf(
                navArgument("nom"){
                    type=NavType.StringType
                },
                navArgument("prenom"){
                    type=NavType.StringType
                }
            )
        ){
            val nomString=it.arguments?.getString("nom")
            val prenomString=it.arguments?.getString("prenom")
            HomeScreen(nomString,prenomString,navHostController)
        }
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navHostController)
        }

        composable(
            route =Screen.AuthScreen.route
        ){
            AuthenticationScreen(navHostController)
        }
    }
}