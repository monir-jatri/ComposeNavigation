package com.soyaeeb.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun ErrorScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val navController = rememberNavController()
        Text(
            text = "Something Went Wrong",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.width(100.dp),
            onClick = { navController.navigate("repo_list") },
        ){
            Text(text = "Retry")
        }
    }
}