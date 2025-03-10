package com.example.ibembang

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.*


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues) // Automatically adjusts for system bars
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    GreetingSection()
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 16.dp) // Prevent content from getting hidden
                        .navigationBarsPadding(), // Respect system nav bar
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    item { BookingSection() }
                    item { RewardsSection() }
                    item { TopRoomsSection() }
                }
            }
        }
    )
}

// GREETING SECTION
@Composable
fun GreetingSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hi, Leonard!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
                )
            Text(text = "Book now to enjoy our deals.", fontSize = 14.sp, color = Color.Black)
        }
        Image(
            painter = painterResource(id = R.drawable.profile_img), // Replace with real image
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
}

// BOOKING SECTION
@Composable
fun BookingSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // First Row - Room Type & Guests
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Room Type",
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, // Ensures it stays on one line
                        fontSize = 14.sp, // Reduce the font size
                        //overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = "Bembang Deluxe",
                        onValueChange = {},
                        leadingIcon = { Icon(Icons.Default.Home, contentDescription = null) },
                        singleLine = true,
                        textStyle = TextStyle(textAlign = TextAlign.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp), // Ensuring uniform height
                        colors = TextFieldDefaults.colors( // will make the textfield color white
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,  // Removes underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                            disabledIndicatorColor = Color.Transparent // Removes underline when disabled
                        ),
                        shape = RoundedCornerShape(12.dp) // Rounded corners
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "How many guests?",
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, // Ensures it stays on one line
                        fontSize = 14.sp, // Reduce the font size
                        //overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = "2 Guests",
                        onValueChange = {},
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                        singleLine = true,
                        textStyle = TextStyle(textAlign = TextAlign.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp), // Ensuring uniform height
                        colors = TextFieldDefaults.colors( // will make the textfield color white
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,  // Removes underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                            disabledIndicatorColor = Color.Transparent // Removes underline when disabled
                        ),
                        shape = RoundedCornerShape(12.dp) //Rounded corners
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Second Row - Check-in & Check-out
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Check In",
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, // Ensures it stays on one line
                        fontSize = 14.sp, // Reduce the font size
                        //overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = "02-14-2025",
                        onValueChange = {},
                        leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                        singleLine = true,
                        textStyle = TextStyle(textAlign = TextAlign.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp), // Ensuring uniform height
                        colors = TextFieldDefaults.colors( // will make the textfield color white
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,  // Removes underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                            disabledIndicatorColor = Color.Transparent // Removes underline when disabled
                        ),
                        shape = RoundedCornerShape(12.dp) //Rounded corners
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Check Out",
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1, // Ensures it stays on one line
                        fontSize = 14.sp, // Reduce the font size
                        //overflow = TextOverflow.Ellipsis
                        )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = "02-15-2025",
                        onValueChange = {},
                        leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                        singleLine = true,
                        textStyle = TextStyle(textAlign = TextAlign.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp), // Ensuring uniform height
                        colors = TextFieldDefaults.colors( // will make the textfield color white
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,  // Removes underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                            disabledIndicatorColor = Color.Transparent // Removes underline when disabled
                        ),
                        shape = RoundedCornerShape(12.dp) //Rounded corners
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Book Now Button
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF122E66))
            ) {
                Text("Book now", color = Color.White)
            }
        }
    }
}


// REWARDS SECTION
@Composable
fun RewardsSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(170.dp), // Adjust height for better spacing
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF122E66))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(2f)
            ) {
                Text(
                    "Book, Collect, and enjoy the perks with Bembang points",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .width(120.dp) // Smaller button
                        .height(36.dp)
                ) {
                    Text("Start now", color = Color.White, fontSize = 14.sp)
                }
            }
            //Spacer(modifier = Modifier.width(8.dp)) // Adjust spacing between text and image
            Image(
                painter = painterResource(id = R.drawable.perks_badge), // Use your sticker image
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.3f) // 30% of the parent width
                    .aspectRatio(1f) // Keeps the image square
            )
        }
    }
}



// TOP ROOM CHOICES SECTION
@Composable
fun TopRoomsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Top Room Choices!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("View all", color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bembang_deluxe),
                    contentDescription = "Room Image",
                    contentScale = ContentScale.Crop,  // Keeps proportions, crops excess
                    modifier = Modifier
                        .width(110.dp)  // Set a fixed width
                        .height(110.dp) // Set a fixed height
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Gray) // Helps visualize space if image doesn't load
                )


                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Bembang Deluxe", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = "Star", tint = Color(0xFFFFD700))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("5.0 (69 Reviews)", fontSize = 14.sp, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Person, contentDescription = "Guests", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("2 Guests", fontSize = 14.sp, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("350 PHP / 3hrs", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)

                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /* Future process here */ },
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
}


// BOTTOM NAVIGATION BAR
//@Composable
//fun BottomNavBar(navController: NavController) {
//    BottomNavigation(
//        backgroundColor = Color.White,
//        elevation = 8.dp
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            label = { Text("HOME") },
//            selected = true,
//            onClick = { /* Navigate */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Hotel, contentDescription = "Rooms") },
//            label = { Text("ROOMS") },
//            selected = false,
//            onClick = { /* Navigate */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Email, contentDescription = "Message") },
//            label = { Text("MESSAGE") },
//            selected = false,
//            onClick = { /* Navigate */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = "Booking") },
//            label = { Text("BOOKING") },
//            selected = false,
//            onClick = { /* Navigate */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
//            label = { Text("PROFILE") },
//            selected = false,
//            onClick = { /* Navigate */ }
//        )
//    }
//}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}