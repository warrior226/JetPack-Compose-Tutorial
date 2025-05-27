package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var randomNumber=Random.nextInt(20)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState!=null){
            randomNumber=savedInstanceState.getInt("random")
        }
        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier.background(Color.White).fillMaxSize()) { innerPadding ->
                    Greeting(
                        name="$randomNumber",
                        modifier=Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("random",randomNumber)
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}

//@Composable
//@Preview(showBackground = true)
//fun GreetingPreview(name: String, modifier: Modifier = Modifier) {
//    Text(text = "Hello $name!")
//}



