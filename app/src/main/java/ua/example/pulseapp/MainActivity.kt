package ua.example.pulseapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ua.example.pulseapp.navigation.HeartApp
import ua.example.pulseapp.screens.MeasurementScreen
import ua.example.pulseapp.screens.OnBoardingScreen
import ua.example.pulseapp.ui.theme.PulseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PulseAppTheme {
                HeartApp(navHostController = rememberNavController(), context = this)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PulseAppTheme {
        MeasurementScreen(isActive = false) {
            
        }
    }
}