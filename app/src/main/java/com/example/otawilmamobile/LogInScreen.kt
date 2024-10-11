package com.example.otawilmamobile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun LogInScreen(){

    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image( // App logo
            painter = painterResource(R.drawable.baseline_deblur_24),
            colorFilter = ColorFilter.tint(Color.Cyan),
            contentDescription = "OtaWilma logo",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Welcome to OtaWilma",
            fontSize = 22.sp
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(text = "Username", color = Color.Gray)
            }
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(text = "Password", color = Color.Gray)
            }
        )
        Spacer(
            modifier = Modifier.height(25.dp)
        )
        Button(
            onClick = {
                Toast.makeText(context,"Logging in not implemented yet :p", Toast.LENGTH_SHORT).show()
            }
        ){
            Text(text = "Log In")
        }
    }
}