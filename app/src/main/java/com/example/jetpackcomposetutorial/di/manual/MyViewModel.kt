package com.example.jetpackcomposetutorial.di.manual

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposetutorial.MyAppDataBase
import com.example.jetpackcomposetutorial.di.hilt.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


class MyViewModel(
    private val dataBase: MyAppDataBase, //This is how we inject dependencies into viewModels
    private val repository: MyRepository
):ViewModel() {

    var state by mutableStateOf("database not synced")//
    private set //This is used to make the state variable immutable

    fun syncDataBase(){
        val data=repository.fetchData()
        dataBase.addData(data)
        state="database synced"
    }

    fun getInfo():List<String>{
        return listOf("RAYAISSE","Patrick")
    }
}