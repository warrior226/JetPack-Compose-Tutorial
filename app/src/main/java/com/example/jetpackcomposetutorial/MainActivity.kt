package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.di.hilt.MyViewModel
import com.example.jetpackcomposetutorial.di.manual.ManualApplication
import com.example.jetpackcomposetutorial.screen.SetupNavGraph
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            JetPackComposeTutorialTheme {
                var navHostController: NavHostController
                val hiltViewModel = hiltViewModel<MyViewModel>()
                val  nom= hiltViewModel.getInfo()[0]
                val prenom= hiltViewModel.getInfo()[1]
                val koinViewModel=koinViewModel<com.example.jetpackcomposetutorial.di.koin.MyViewModel>()
                val manualViwModel= viewModel<MyViewModel>(
                    factory=ManualApplication.manualAppModule.myViewModelFactory
                )

                Scaffold(
                    topBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent)
                                .padding(WindowInsets.statusBars.asPaddingValues())
                        ) {
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color.White)
                    ) {
                        // Your main content
                        navHostController= rememberNavController()
                        SetupNavGraph(navHostController)
                    }
                }
            }
        }
    }
}



