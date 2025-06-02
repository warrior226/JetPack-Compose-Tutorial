package com.example.jetpackcomposetutorial

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
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

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val menusList=listOf("Accueil","Paramètres")
            var menuSelected by rememberSaveable { mutableStateOf(menusList[0]) }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("My App")
                        },
                        navigationIcon = {
                            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Logo")
                        },
                        actions = {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "Profile"
                                )
                            }
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Menus plus"
                                )
                            }
                        }
                    )
                },
                bottomBar = {
                    NavigationBar {
                        menusList.forEach {menu->
                            NavigationBarItem(
                                selected = menuSelected==menu,
                                onClick = {
                                    menuSelected=menu
                                },
                                icon ={
                                   Icon(imageVector=Icons.Default.Home, contentDescription = "Icon")

                                },
                                label={
                                    Text(menu)
                                }
                            )

                        }
                    }
                },
                floatingActionButton = {
                    ExtendedFloatingActionButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Ajouter"
                        )
                        Text("Ajouter")
                    }
                }
            ) {
                paddingValue->
                Box(
                    modifier = Modifier
                        .padding(paddingValue)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text=menuSelected)
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}






