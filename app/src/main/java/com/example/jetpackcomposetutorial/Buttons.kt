package com.example.jetpackcomposetutorial
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.screen.Screen


@Composable
fun FilledButton(onClick:()->Unit,buttonState:Boolean) {
    var filledButtonClicked by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Confirm") }

    Row(
        modifier = Modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick =onClick,
        ) {
            Text(text=buttonText)
            filledButtonClicked=buttonState
        }

        if (filledButtonClicked){
            Spacer(modifier = Modifier.width(16.dp))
            buttonText="Creating account..."
            CircularProgressIndicator(
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp),
                strokeWidth = 2.dp
            )
        }else{
            buttonText="Confirm"
        }

    }

}

@Composable
fun ElevatedButton(){
    ElevatedButton(onClick ={}) {
        Icon(imageVector=Icons.Filled.Add, contentDescription = "add icon", modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Add to cart")
    }
}

@Composable
fun FilledTonalButton(modifier: Modifier = Modifier) {

    FilledTonalButton(onClick ={

    }) {

        Text(text = "Open in browser")
    }
    
}

@Composable
fun OutlinedButon() {

    OutlinedButton(onClick = {

    }) {
        Text("I have an existing account")
    }
}

@Composable
fun TextButton(modifier: Modifier = Modifier) {
    androidx.compose.material3.TextButton(onClick = {

    }) {
        Text("Learn more")
    }
}

@Composable
@Preview(showBackground = true)
fun FilledButtonPreview() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       FilledButton(onClick ={},true)
        ElevatedButton()
        FilledTonalButton()
        OutlinedButon()
        TextButton()

    }
}