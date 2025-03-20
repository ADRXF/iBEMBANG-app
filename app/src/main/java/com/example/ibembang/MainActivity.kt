package com.example.ibembang


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ibembang.ui.theme.IBEMBANGTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            IBEMBANGTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "welcome") {
                    composable("welcome") { WelcomePage(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("register") { CreateAccount(navController) }
                    composable("home") { HomeScreen(navController) }
                    composable("forgotpassword") { ForgotPasswordScreen(navController) }
                    composable("otp") { OTPScreen(navController) }
                    composable("resetpasswordpage") { ResetPasswordPage(navController) }
                    composable("otpverify") { OTPverification (navController) }
                    composable("congrats"){Congratulation(navController)}
                    composable("PersonalInformationGathering") { PersonalInformationGathering (navController) }
                    composable("rooms") { RoomScreen(navController) }
                    composable("message") { MessageScreen(navController) }
                    composable("booking") { BookingScreen(navController) }
                    composable("profile") { ProfileScreen(navController) }
                    composable("viewroominformation") { ViewRoomInformation(navController) }
                }
            }
        }
    }
}
