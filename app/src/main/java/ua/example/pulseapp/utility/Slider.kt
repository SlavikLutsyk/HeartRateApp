package ua.example.pulseapp.utility

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ua.example.pulseapp.ui.theme.*

@Composable
fun Slider(bpm: Int) {
    val maxWidth = 330
    // Перетворення bpm у відповідний офсет повзунка
    val sliderOffset = (bpm.toFloat() / 160.0 * maxWidth - 4).dp

    Box(
        modifier = Modifier
            .padding(vertical =  10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // Фон бару
        Box(
            modifier = Modifier
                .width(maxWidth.dp)
                .height(12.dp)
                .clip(CircleShape)
        ) {
            // Кольорові секції бару
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .height(12.dp)
                        .background(LightBlue)
                ) // Бірюзовий
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .height(12.dp)
                        .background(Green)
                ) // Зелений
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .height(12.dp)
                        .background(Red)
                ) // Червоний
            }
        }
        println(sliderOffset)
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(sliderOffset))
            // Повзунок
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height(16.dp)
                    .clip(CircleShape)
                    .border(1.dp, DarkGray, CircleShape)
                    .background(DarkWhite, CircleShape)

            )
        }
    }
}
