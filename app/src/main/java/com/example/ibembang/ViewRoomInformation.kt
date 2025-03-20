package com.example.ibembang

import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibembang.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import androidx.compose.ui.draw.clip




@Composable
fun ViewRoomInformation(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Overview", "Description", "Review")

    val images = listOf(R.drawable.bembang_deluxe, R.drawable.bembang_deluxe, R.drawable.bembang_deluxe)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        // Header
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                //Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back")
            }
            Text(text = "View Room", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        // Image Carousel with Indicators
        Box(modifier = Modifier.fillMaxWidth().height(220.dp).padding(16.dp)) {
            HorizontalPager(count = images.size, state = pagerState) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Room Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp))
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
                activeColor = Color.Red,
                inactiveColor = Color.LightGray,
                indicatorWidth = 8.dp,
                indicatorHeight = 8.dp
            )
        }

        // Room Info
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = "Bembang Deluxe", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = "Rating", tint = Color(0xFFFFD700))
                Text(text = "5.0 (69 Reviews)", modifier = Modifier.padding(start = 4.dp))
            }

            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Button(onClick = { /* Book Logic */ }, colors = ButtonDefaults.buttonColors(Color(0xFF007AFF))) {
                    Text(text = "BOOK")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Reserve Logic */ }, colors = ButtonDefaults.buttonColors(Color(0xFF007BFF))) {
                    Text(text = "RESERVE")
                }
            }
        }

        // Feature Icons
        Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            FeatureItem(iconId = R.drawable.ic_people, label = "2 Guests")
//            FeatureItem(iconId = R.drawable.ic_wifi, label = "Free Wifi")
//            FeatureItem(iconId = R.drawable.ic_bed, label = "1 King size")
//            FeatureItem(iconId = R.drawable.ic_tv, label = "Smart TV")
        }

        // Tab Row
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        // Tab Content
        when (selectedTab) {
            0 -> Text(text = "A King Bed Room with TV and Free Wi-Fi. Perfect for relaxation.", modifier = Modifier.padding(16.dp))
            1 -> Text(text = "This room includes a king-size bed, free Wi-Fi, Smart TV, and modern decor.", modifier = Modifier.padding(16.dp))
            2 -> Text(text = "Customer reviews will be displayed here.", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun FeatureItem(iconId: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Text(text = label, fontSize = 12.sp)
    }
}
