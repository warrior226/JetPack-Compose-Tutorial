package com.example.jetpackcomposetutorial.screen

const val Home_SCREEN_ROUTE="home"
const val AUTH_SCREEN_ROUTE="authScreen"
const val DETAIL_SCREEN_ROUTE="detailScreen"
sealed class Screen(val route:String) {
    data object AuthScreen:Screen(AUTH_SCREEN_ROUTE)
    data object Detail: Screen(DETAIL_SCREEN_ROUTE)
    //When the data to be transfered is optional
    data object Home: Screen("$Home_SCREEN_ROUTE?nom={nom}&prenom={prenom}"){
        fun passData(
            userLast:String="RAYAISSE",
            userNickName:String="Patrick"
        ):String {

            return "$Home_SCREEN_ROUTE?nom=$userLast&prenom=$userNickName"
        }
    }
}
