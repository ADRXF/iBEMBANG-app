package com.example.ibembang

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController

@Composable
fun PersonalInformationGathering(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val isSaveEnabled = firstName.isNotBlank() && lastName.isNotBlank() && gender.isNotBlank() && address.isNotBlank() && mobileNumber.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Personal Information",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "To enhance your booking experience, please complete your profile by providing the required details below. This step is necessary to proceed with using the app.",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextField(value = firstName, label = "First Name *", onValueChange = { firstName = it }, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            CustomTextField(value = lastName, label = "Last Name *", onValueChange = { lastName = it }, modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextField(value = middleName, label = "Middle Name", onValueChange = { middleName = it }, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            CustomTextField(value = gender, label = "Gender *", onValueChange = { gender = it }, modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(value = address, label = "Address *", onValueChange = { address = it })

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(value = mobileNumber, label = "Mobile Number *", onValueChange = { mobileNumber = it })

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(value = email, label = "Email Address", onValueChange = { email = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("congrats") },
            enabled = isSaveEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSaveEnabled) Color(0xFF1C274C) else Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Save", fontSize = 19.sp)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, label: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = label, fontSize = 14.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),  // Setting text color here
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}
