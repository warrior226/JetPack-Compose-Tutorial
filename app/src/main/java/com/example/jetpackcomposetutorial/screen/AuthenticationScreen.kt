package com.example.jetpackcomposetutorial.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorial.FilledButton
import com.example.jetpackcomposetutorial.R


data class ToogleableInfo(
    var isCkecked:Boolean,
    var text:String
    )


@Composable
fun AuthenticationScreen(navHostController: NavHostController){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmedPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false) }
    var passwordConfirmedVisibility by remember{ mutableStateOf(false) }
    val icon = if(passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)
    val iconConfirmPassword = if(passwordConfirmedVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)

    var checkboxInfo by remember {
        mutableStateOf(
            ToogleableInfo(
                isCkecked =true,
                text="I agree with terms and conditions."
            )
        )
    }
    var buttonState by remember { mutableStateOf(false) }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text="Welcome",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text="Create your account or Login",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text="Username",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = username,
                onValueChange = {
                    username=it
                },
                label = {
                    Text(
                        text="Username"
                    )

                },
                placeholder = {
                    Text(
                        text="Rayaisse Patrick",
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        color = Color.LightGray, fontWeight = FontWeight.Bold
                    )

                },
                textStyle=TextStyle(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                shape =MaterialTheme.shapes.medium,

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text="Email",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value =email,
                onValueChange = {
                    email=it
                },
                label = {
                    Text(
                        text="Email"
                    )

                },
                placeholder = {
                    Text(
                        text="patrickrayaisse@gmail.com",
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        color = Color.LightGray, fontWeight = FontWeight.Bold
                    )

                },
                textStyle=TextStyle(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                shape =MaterialTheme.shapes.medium,
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "email icon", tint = Color.LightGray)
                }

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text="Password",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value =password,
                onValueChange = {
                    password=it
                },
                label = {
                    Text(
                        text="Password"
                    )

                },
                placeholder = {
                    Text(
                        text="Password",
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        color = Color.LightGray, fontWeight = FontWeight.Bold
                    )

                },
                textStyle=TextStyle(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                shape =MaterialTheme.shapes.medium,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibility=!passwordVisibility
                        }) {
                        Icon(painter = icon, contentDescription = "Password Icon", tint = Color.LightGray)

                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text="Confirm Password",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmedPassword,
                onValueChange = {
                    confirmedPassword=it
                },
                label = {
                    Text(
                        text="Password"
                    )

                },
                placeholder = {
                    Text(
                        text="Password",
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        color = Color.LightGray, fontWeight = FontWeight.Bold
                    )

                },
                textStyle=TextStyle(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                shape =MaterialTheme.shapes.medium,
                visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordConfirmedVisibility=!passwordConfirmedVisibility
                        }) {
                        Icon(painter = iconConfirmPassword, contentDescription = "Password Icon", tint = Color.LightGray)

                    }
                }
            )
            if(password!=confirmedPassword){
                Text(
                    text ="The entered password is different from the password defined previously",
                    fontStyle = FontStyle.Normal,
                    color = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked =checkboxInfo.isCkecked,
                onCheckedChange = {
                    checkboxInfo=checkboxInfo.copy(isCkecked =it)
                },
                colors = CheckboxColors(
                    checkedBoxColor = Color(0xFF063970),
                    checkedCheckmarkColor = Color.White,
                    uncheckedCheckmarkColor =Color.LightGray,
                    uncheckedBoxColor = Color.White,
                    disabledCheckedBoxColor = Color.LightGray,
                    disabledUncheckedBoxColor = Color.LightGray,
                    disabledIndeterminateBoxColor = Color.LightGray,
                    checkedBorderColor = Color(0xFF063970),
                    uncheckedBorderColor = Color.LightGray,
                    disabledBorderColor = Color.LightGray,
                    disabledUncheckedBorderColor = Color.LightGray,
                    disabledIndeterminateBorderColor = Color.LightGray
                )
            )
            Text(
                text = checkboxInfo.text,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = Color.LightGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        FilledButton(onClick={
            Log.d("TAG", "AuthenticationScreen: The button has been clicked ")
            buttonState=!buttonState
            navHostController.navigate(Screen.Home.passData())
        },buttonState)
    }
}


@Composable
@Preview(showBackground = true)
fun AuthenticationScreenPreview() {
    AuthenticationScreen(rememberNavController())
}