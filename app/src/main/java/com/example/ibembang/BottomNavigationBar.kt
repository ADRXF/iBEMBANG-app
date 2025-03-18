package com.example.ibembang

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", "Home", R.drawable.ic_home, R.drawable.ic_home), //R.drawable.ic_home_selected
        BottomNavItem("rooms", "Rooms", R.drawable.ic_rooms, R.drawable.ic_rooms), //ic_rooms_selected
        BottomNavItem("message", "Message", R.drawable.ic_message, R.drawable.ic_message), //ic_message_selected
        BottomNavItem("booking", "Booking", R.drawable.ic_booking, R.drawable.ic_booking), //ic_booking_selected
        BottomNavItem("profile", "Profile", R.drawable.ic_people, R.drawable.ic_people) //ic_profile_selected
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

//    NavigationBar(
//        containerColor = Color.White,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(65.dp)
//    )
    NavigationBar{
        items.forEach { item ->
            val isSelected = currentDestination == item.route

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) item.selectedIcon else item.defaultIcon),
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp),
                        tint = if (isSelected) Color(0xFF102C57) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = if (isSelected) Color(0xFF102C57) else Color.Gray
                    )
                },
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            popUpTo("home") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

// Data class for Bottom Navigation Items
data class BottomNavItem(
    val route: String,
    val title: String,
    val defaultIcon: Int,
    val selectedIcon: Int
)

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}
