package com.example.jetpackcomposetutorial

import android.content.Context

class MyAppDataBase(
    context: Context
) {

fun addData(data:List<String>){
    println("Adding data!!${data.size}");
}
}