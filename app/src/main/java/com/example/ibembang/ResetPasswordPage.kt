package com.example.ibembang

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ibembang.R

val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun ResetPasswordPage(navController: NavController) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Reset Password", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black, style = TextStyle(fontFamily = poppins))
            Text("Please enter your new password.", fontSize = 15.sp, color = Color.Gray, style = TextStyle(fontFamily = poppins))

            Spacer(modifier = Modifier.height(24.dp))

            Text("Enter New Password", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.Black, style = TextStyle(fontFamily = poppins), modifier = Modifier.align(Alignment.Start))
            PasswordField(
                password = newPassword,
                onPasswordChange = { newPassword = it },
                passwordVisible = newPasswordVisible,
                onVisibilityChange = { newPasswordVisible = !newPasswordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Re-enter Password", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.Black, style = TextStyle(fontFamily = poppins), modifier = Modifier.align(Alignment.Start))
            PasswordField(
                password = confirmPassword,
                onPasswordChange = { confirmPassword = it },
                passwordVisible = confirmPasswordVisible,
                onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { showDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A1A3D)),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Reset Password", fontSize = 20.sp, color = Color.White, style = TextStyle(fontFamily = poppins))
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = null,
                    text = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text(
                                    "Password Successfully Changed",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(fontFamily = poppins)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {
                                        showDialog = false
                                        navController.navigate("login")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(
                                            0xFF1A1A3D
                                        )
                                    )
                                ) {
                                    Text(
                                        "Ok",
                                        color = Color.White,
                                        style = TextStyle(fontFamily = poppins)
                                    )
                                }
                            }
                    },
                    confirmButton = {}
                )
            }
        }
    }
}

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            IconButton(onClick = onVisibilityChange) {
                Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
            }
        },
        textStyle = TextStyle(fontFamily = poppins)
    )
}
