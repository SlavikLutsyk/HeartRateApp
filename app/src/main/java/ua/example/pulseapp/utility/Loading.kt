package ua.example.pulseapp.utility


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.ui.theme.LightRed
import ua.example.pulseapp.ui.theme.Red

@Composable
fun Loading(percentage: Float, isLoaded: MutableState<Boolean>, onFinishedLoading: ()->Unit){
    val animatedProgress by animateFloatAsState(
        targetValue = percentage,  // Кінцеве значення анімації
        animationSpec = tween(durationMillis = 2000) // Налаштування анімації (1 секунда)
    )

    Box(
        modifier = Modifier
            .width(331.dp)
            .height(16.dp)
            .background(Red, shape = RoundedCornerShape(8.dp)) // Заокруглення кутів прогрес-бару
    ) {
        LinearProgressIndicator(
            progress = animatedProgress, // Використовуємо анімоване значення
            color = Red,
            backgroundColor = LightRed, // Задній фон прогрес-бару
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)) // Заокруглення кутів прогрес-бару
        )
        Text(
            text = (animatedProgress * 100).toInt().toString() + "%", // Текст всередині прогрес-бару
            color = Color.White, // Колір тексту
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center) // Центрування тексту всередині прогрес-бару
        )
    }
    if (isLoaded.value)
        onFinishedLoading()
}