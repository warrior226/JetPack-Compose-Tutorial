package com.example.jetpackcomposetutorial.di.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application() //to tell hilt that this is the application class