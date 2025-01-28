package ua.example.pulseapp.utility

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import ua.example.pulseapp.ui.theme.Gray
import ua.example.pulseapp.ui.theme.Red

@Composable
fun ScrollDots(activeIndex: MutableState<Int>) {

    // Висота індикаторів (стала)
    val indicatorHeight = 14.dp

    // Анімація зміщення активного індикатора
    val animatedOffsetX by animateDpAsState(
        targetValue = when (activeIndex.value) {
            0 -> 0.dp
            1 -> 28.dp // відстань між індикаторами
            else -> 56.dp
        }
    )

    Box(modifier = Modifier
        .padding(16.dp)
        .width(112.dp) // сумарна ширина всіх індикаторів
        .height(indicatorHeight)) {

        // Неактивні індикатори (сірі)
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            for (i in 0 until 4) {
                InactiveDot()
            }
        }

        // Активний індикатор (переміщається)
        ActiveMovingDot(
            modifier = Modifier
                .offset(x = animatedOffsetX)
        )
    }
}

@Composable
fun InactiveDot() {
    Canvas(
        modifier = Modifier
            .size(14.dp)
    ) {
        drawRoundRect(
            color = Gray,
            cornerRadius = CornerRadius(50f, 50f)
        )
    }
}

@Composable
fun ActiveMovingDot(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(42.dp, 14.dp) // більший активний індикатор
    ) {
        drawRoundRect(
            color = Red,
            cornerRadius = CornerRadius(50f, 50f)
        )
    }
}
