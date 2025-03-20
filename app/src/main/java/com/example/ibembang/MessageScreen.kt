package com.example.ibembang

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen(navController: NavController) {
    var selectedTab by remember { mutableIntStateOf(0) } // Track selected tab

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Messages",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.font_color_drkblu)
                        )
                    )
                }
            )
        },
        bottomBar = { BottomNavigationBar(navController) } // Uses your existing BottomNav
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(colorResource(id = R.color.ContentBgColor))
        ) {
            // Tabs Section
            TabRow(selectedTabIndex = selectedTab, containerColor = Color.White) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("Ongoing", fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("Closed", fontWeight = FontWeight.Bold) }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // New Message Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                ElevatedButton(
                    onClick = { /* TODO: Handle new message click */ },
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_square_and_pen),
                        contentDescription = "New Message Icon",
                        modifier = Modifier.size(18.dp),
                        tint = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "New Message",
                        color = colorResource(id = R.color.black)
                    )
                }
            }

            // Message List (Hardcoded for now)
            MessageCard("Biokid", "msg#68420", "Mar 3, 2025", "Ongoing")
        }
    }
}


@Composable
fun MessageCard(username: String, messageId: String, date: String, status: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { /* Open Chat */ },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(username, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(messageId, fontSize = 12.sp, color = Color.Gray)
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(date, fontSize = 12.sp, color = Color.Gray)
                StatusBadge(status)
            }
        }
    }
}

@Composable
fun StatusBadge(status: String) {
    val backgroundColor = if (status == "Ongoing") Color.Blue else Color.Gray
    Surface(
        modifier = Modifier.padding(top = 4.dp),
        color = backgroundColor,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = status,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun PreviewMessageScreen() {
    MessageScreen(navController = NavController(LocalContext.current))
}