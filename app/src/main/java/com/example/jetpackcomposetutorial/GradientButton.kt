package com.example.jetpackcomposetutorial

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.color1
import com.example.jetpackcomposetutorial.ui.theme.color2

@Composable
fun GradientButton(
    text:String,
    textColor: Color,
    gradient: Brush,
    onClick:()->Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.Transparent,

           ),
            contentPadding = PaddingValues(6.dp,6.dp),
            onClick = {
                onClick()
            }
        ){
            Box(
                modifier = Modifier
                    .background(gradient) //Ww can find all the different gradients on uigradients.com
                    .padding(16.dp, 8.dp)
                    .width(50.dp)
                    .height(25.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(text, color = textColor)

            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun GradientButtonPreview(){
    GradientButton(
        text = "Button",
        textColor = Color.White,
        gradient = Brush.horizontalGradient(
            colors = listOf(
                color1,
                color2
            )
        ),
        onClick ={
            Log.d("TAG", "GradientButtonPreview:Button has been clicked ")
        }

    )
}