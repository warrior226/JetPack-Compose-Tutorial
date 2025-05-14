package com.example.jetpackcomposetutorial.screen

sealed class Screen(val route:String) {
    data object Home:Screen("homeScreen")
    data object Detail: Screen("detailScreen")
}