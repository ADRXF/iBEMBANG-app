package com.example.ibembang

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Congratulation(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center  // Aligning content to the center of the screen
    ) {
        Image(
            painter = painterResource(id = R.drawable.congrats), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(300.dp) // Reduced size to make it more compressed
        )

        Spacer(modifier = Modifier.height(16.dp)) // Reduced space between image and text

        Text(
            text = "Congratulations!",
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Welcome to the Bembang family! Your account is now verified, and you're all set to enjoy seamless hotel bookings, exclusive reservations, and special discounts. Start your journey with us today!\n\nThank you for signing up with us!",
            style = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("home")
            },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D1E6C)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Continue", color = Color.White, fontSize = 18.sp)
        }
    }
}