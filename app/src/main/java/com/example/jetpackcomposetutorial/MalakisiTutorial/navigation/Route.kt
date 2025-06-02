package com.example.jetpackcomposetutorial.MalakisiTutorial.navigation

import kotlinx.serialization.Serializable

object Route {
    @Serializable
    object ScreenA
    @Serializable
    object ScreenB
    //if the data
    @Serializable
    data class ScreenC(
        val myText: String,
        val myNumber:Int
    )
    @Serializable
    data class ScreenD(
        val nom: String,
        val prenom:String
    )
}