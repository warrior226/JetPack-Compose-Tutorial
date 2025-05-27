package com.example.jetpackcomposetutorial.di.manual

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.jetpackcomposetutorial.MyAppDataBase
import com.example.jetpackcomposetutorial.di.hilt.MyRepository

interface ManualAppModule{
    val database: MyAppDataBase
    val repository: MyRepository
    val myViewModelFactory: ViewModelProvider.Factory
}

class ManualAppModuleImpl(
    private val appContext: Context
): ManualAppModule {
    override val database: MyAppDataBase by lazy{
        MyAppDataBase(appContext)
    }

    override val repository: MyRepository
        get()=MyRepository()

    override val myViewModelFactory: ViewModelProvider.Factory
        get() = viewModelFactory {
            MyViewModel(database,repository)
        }

}