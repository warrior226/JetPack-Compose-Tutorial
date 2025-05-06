package com.example.jetpackcomposetutorial

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha

@Composable
fun ExpandableCard(
    title:String,
    titleFontSize:TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description:String,
    descriptionFontSize:TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines:Int = 4,
    shape:CornerBasedShape= MaterialTheme.shapes.medium,
    padding: Dp = 12.dp
){
    //First we are created the state of our card (expanded or not) so that it can survive after a recomposition
    var expandedState  by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier.fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(padding)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    title,
                    fontSize = titleFontSize,
                    fontWeight =titleFontWeight,
                    modifier = Modifier.weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                    )

                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium)
                    .rotate(rotation),
                    onClick = {
                        expandedState=!expandedState
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription ="Drop-Down Arrow")
                }

            }

            if(expandedState){
                Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    fontSize = descriptionFontSize,
                    fontWeight =descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }

}

@Composable
@Preview
fun ExpandableCardPreview(){
    ExpandableCard(title="My Title", description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
}
