package com.example.jetpackcomposetutorial.di.hilt

import android.content.Context
import com.example.jetpackcomposetutorial.MyAppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//This is the containe that wraps all our dependencies


@Module
@InstallIn(SingletonComponent::class) //All the dependencies in this module live as long as our application does
object AppModule {

    @Provides
    @Singleton //Only one instance of this object will be created
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MyAppDataBase{
        return MyAppDataBase(context) // so this object will be created only once and will be shared by all the classes that need it
    }

    @Provides
    @Singleton
    fun provideMyRepository():MyRepository{
        return MyRepository()

    }
}