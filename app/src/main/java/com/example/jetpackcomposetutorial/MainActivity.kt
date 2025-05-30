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
import com.example.jetpackcomposetutorial.MalakisiTutorial.ThirdActivity
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var randomNumber=Random.nextInt(20)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) { innerPadding ->
                    MyUI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}


@Composable
fun MyUI(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        //To Specify the number of page . here we have 2 pages
        val pagerState = rememberPagerState(pageCount={2})
        val color=if(pagerState.currentPage==0)Color.Yellow else Color.Green
        HorizontalPager(
            state =pagerState
        ) {
            Box(modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .background(color)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MyUIPreview() {
    MyUI(modifier = Modifier)
}


