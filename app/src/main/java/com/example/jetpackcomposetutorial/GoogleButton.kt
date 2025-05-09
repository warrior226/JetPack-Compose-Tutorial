package com.example.jetpackcomposetutorial

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun GoogleButton(
    text:String="Sign Up with Google",
    loadingText:String="Creating Account ...",
    icon: Painter = painterResource(R.drawable.ic_google_logo),
    shape: CornerBasedShape=MaterialTheme.shapes.medium,
    borderColor: Color=Color.LightGray,
    backgroundColor:Color=Color.White,
    progressIndicatorColor:Color=MaterialTheme.colorScheme.primary,
    onClicked:()->Unit

){
    var clicked by remember{ mutableStateOf(false) }
    Surface(
        onClick = {
            Log.d("TAG", "GoogleButton: The Google Button has been clicked ");
            clicked=!clicked;
        },
        shape =shape,
        border = BorderStroke(1.dp, borderColor),
        color =backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = icon, contentDescription ="Google Sign Up Button", tint = Color.Unspecified);
            Spacer(modifier = Modifier.width(8.dp))
            Text(if(clicked) loadingText else text, color = Color.Black, fontWeight = FontWeight.Bold)

            if(clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color =progressIndicatorColor

                )
                 onClicked
            }
        }
    }

}

@Composable
@Preview
@Preview(showBackground = true)
@ExperimentalMaterial3Api
fun GoogleButtonPreview(){
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        GoogleButton(
            "Inscrivez-vous",
            "Insciption en cours....",
            onClicked = {
                Log.d("TAG", "GoogleButtonPreview:Clicked")
            }
        )
    }
}