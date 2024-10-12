package com.example.otawilmamobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(paddingValues: PaddingValues){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxWidth()
                .height(140.dp)
                .background(color = MaterialTheme.colorScheme.onPrimary),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier.padding(4.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_person_24),
                    contentDescription = "Your profile photo",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = "Welcome, Student",
                    fontSize = 16.sp,
                )
            }
        }
    }
}