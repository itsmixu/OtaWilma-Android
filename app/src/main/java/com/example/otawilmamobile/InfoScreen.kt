package com.example.otawilmamobile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InfoScreen(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .padding(top = paddingValues.calculateTopPadding()),

        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text( // Header
            text = "Disclaimer",
            fontSize = 45.sp,
            color = Color.Red
        )
        Spacer(
            modifier = Modifier.size(28.dp)
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = "This is NOT an official Wilma client. By using OtaWilma, you do understand that this is a project made by a non-professional, so this app won't always work. Additionally, this app handles your Wilma credentials. You should always review the source code of this app yourself to determine if it is safe. I have documented (or will in the future) all of the security measures in the GitHub repo, so please familiarize yourself with those.",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier.size(28.dp)
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = "If you have issues or want to suggest features, contact me at ...",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}