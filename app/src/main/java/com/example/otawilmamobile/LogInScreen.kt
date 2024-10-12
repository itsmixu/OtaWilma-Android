package com.example.otawilmamobile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LogInScreen(){

    var studentName by remember { mutableStateOf("") }
    var studentClass by remember { mutableStateOf("") }


    // Temporary variables to hold input
    var nameInput by remember { mutableStateOf("") }
    var classInput by remember { mutableStateOf("") }

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
        if (studentName.isNotBlank()){
            Text(
                text = "Welcome, $studentName to OtaWilma.",
                fontSize = 22.sp
            )
        }
        else{
            Text(
                text = "Welcome to OtaWilma",
                fontSize = 22.sp
            )
        }

        Text(
            text = "Log in below with your Wilma account.",
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Row(modifier = Modifier.padding(12.dp)){
            OutlinedTextField(
                value = nameInput,
                onValueChange = { nameInput = it },
                placeholder = {
                    Text(text = "Enter your name", color = Color.Gray)
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                value = classInput,
                onValueChange = { classInput = it },
                placeholder = {
                    Text(text = "Class", color = Color.Gray)
                },
                modifier = Modifier.weight(0.6f)
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )
        Button(
            onClick = {
                studentName = nameInput
                studentClass = classInput
                Toast.makeText(context,"Hello $studentName!", Toast.LENGTH_SHORT).show()
            }
        ){
            Text(text = "Save")
        }
    }
}