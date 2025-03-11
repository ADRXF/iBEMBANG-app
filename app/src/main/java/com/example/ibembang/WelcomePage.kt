package com.example.ibembang

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomePage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1), // Your image file in res/drawable
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Scale image to fill screen
        )

        // Your UI content (e.g., button, text) goes here
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            //Spacer(modifier = Modifier.height(100.dp))

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A1A3D), // Background color
                        contentColor = Color.White // Text color
                )
            ) {
                Text("Get Started")
            }
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }

}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    println("Hello, Kotlin!")

    WelcomePage(navController = rememberNavController())
}
