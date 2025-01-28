package ua.example.pulseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.utility.Loading
import ua.example.pulseapp.vectors.HeartBeat

@Composable
fun LoadingScreen(isLoaded: MutableState<Boolean>, onFinishedLoading: ()->Unit) {
    BackgroundImage()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 150.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberVectorPainter(image = HeartBeat),
            contentDescription = null,
            modifier = Modifier.scale(0.95f)
        )
        Text(
            text = "Heart Rate",
            fontFamily = FontFamily.SansSerif,
            fontSize = 54.sp,
            fontWeight = FontWeight(600)
        )
        Box(
            contentAlignment = Alignment.BottomCenter, // Центрування елементів всередині Box
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 42.dp)
        ) {
            Loading(percentage = 0.99f, isLoaded, onFinishedLoading)
        }
    }
}
