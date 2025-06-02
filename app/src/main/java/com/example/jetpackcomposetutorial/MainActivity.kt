package com.example.jetpackcomposetutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jetpackcomposetutorial.MalakisiTutorial.ThirdActivity
import com.example.jetpackcomposetutorial.MalakisiTutorial.navigation.Route
import com.example.jetpackcomposetutorial.MalakisiTutorial.navigation.ScreenA
import com.example.jetpackcomposetutorial.MalakisiTutorial.navigation.ScreenB
import com.example.jetpackcomposetutorial.MalakisiTutorial.navigation.ScreenC
import com.example.jetpackcomposetutorial.MalakisiTutorial.navigation.ScreenD
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var randomNumber=Random.nextInt(20)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
                val navController= rememberNavController()
                NavHost(
                    navController=navController,
                    startDestination =Route.ScreenA
                ) {
                    composable<Route.ScreenA> {
                        ScreenA(onNavigateToScreenB ={
                            navController.navigate(Route.ScreenB)
                        })
                    }

                    composable<Route.ScreenB>{
                        ScreenB(onNavigateToScreenC ={text,number->
                            navController.navigate(Route.ScreenC(
                                myText = text,
                                myNumber = number
                            ))
                        })
                    }

                    composable<Route.ScreenC> {
                        val args=it.toRoute<Route.ScreenC>()
                        ScreenC(
                            args.myText,
                            args.myNumber,
                            onNavigateToScreenD = {nom,prenom->
                                navController.navigate(Route.ScreenD(
                                    nom=nom,
                                    prenom=prenom
                                ))
                            }
                        )
                    }

                    composable<Route.ScreenD>{
                        val args=it.toRoute<Route.ScreenD>()
                        ScreenD(
                            args.nom,
                            args.prenom
                        )

                    }
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}






