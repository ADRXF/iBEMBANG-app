package com.example.ibembang

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable



@Composable
fun RoomScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.MainBgColor))
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.ContentBgColor))
                    .padding(top = 5.dp)
            ) {
                Text(
                    text = "Available Rooms",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(getRoomList()) { room ->
                    RoomItem(room, navController) // Pass navController
                }
            }
        }
    }
}

@Composable
fun RoomItem(room: Room, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Change this to your desired color
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = room.imageRes),
                contentDescription = "Room Image",
                contentScale = ContentScale.Crop,  // Keeps proportions, crops excess
                modifier = Modifier
                    .width(130.dp)  // Set a fixed width
                    .height(150.dp) // Set a fixed height
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Gray) // Helps visualize space if image doesn't load
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = room.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Rating",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "5.0 (69 Reviews)", fontSize = 14.sp, modifier = Modifier.padding(start = 4.dp))
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_people),
                        contentDescription = "Guests",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(text = "${room.guests} Guests", fontSize = 14.sp, modifier = Modifier.padding(start = 4.dp))
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${room.price} PHP / 3hrs",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF007BFF),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { navController.navigate("viewroominformation") },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)),
                    modifier = Modifier
                        .width(100.dp) // Smaller button
                        .height(36.dp)
                ) {
                    Text("VIEW", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

data class Room(
    val name: String,
    val imageRes: Int,
    val guests: Int,
    val price: Int
)

fun getRoomList(): List<Room> {
    return listOf(
        Room("Bembang Deluxe", R.drawable.bembang_deluxe, 2, 350),
        Room("Bembang Standard", R.drawable.bembang_deluxe, 2, 150),
        Room("Bembang Twin", R.drawable.bembang_deluxe, 2, 250),
        Room("Bembang Family", R.drawable.bembang_deluxe, 4, 500),
        Room("Bembang Suite", R.drawable.bembang_deluxe, 5, 1500)

    )
}


@Preview
@Composable
fun PreviewRoomScreen() {
    RoomScreen(navController = rememberNavController())
}