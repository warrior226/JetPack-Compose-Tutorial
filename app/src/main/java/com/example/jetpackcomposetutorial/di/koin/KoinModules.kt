package com.example.jetpackcomposetutorial.di.koin

import com.example.jetpackcomposetutorial.MyAppDataBase
import com.example.jetpackcomposetutorial.di.hilt.MyRepository
import com.example.jetpackcomposetutorial.di.hilt.MyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single{ MyAppDataBase(androidContext()) }
}

val viewModelModule=module{
    factoryOf(::MyRepository)//This is how we inject dependencies into viewModels
    viewModelOf(::MyViewModel)
}
