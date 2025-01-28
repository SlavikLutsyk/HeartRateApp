package ua.example.pulseapp.utility

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

fun Modifier.verticalScrollbar(
    scrollState: ScrollState,
    scrollBarWidth: Dp = 6.dp,
    minScrollBarHeight: Dp = 5.dp,
    scrollBarColor: Color = Color.Blue,
    cornerRadius: Dp = 5.dp,
    scaleCornerRadius: Dp = 6.dp,
    scaleColor: Color = Color.Red, // Колір шкали
    scaleWidth: Dp = 6.dp // Ширина шкали
): Modifier = composed {

    drawWithContent {
        drawContent()

        val visibleHeight: Float = this.size.height - scrollState.maxValue - 200
        val scrollBarHeight: Float = max(visibleHeight * (visibleHeight / this.size.height), minScrollBarHeight.toPx())
        val scrollPercent: Float = scrollState.value.toFloat() / scrollState.maxValue
        val scrollBarOffsetY: Float = scrollState.value + (visibleHeight - scrollBarHeight) * scrollPercent

        // Малювання шкали
        drawRoundRect(
            color = scaleColor,
            topLeft = Offset(this.size.width + 45, scrollState.value.toFloat() + 200),
            size = Size(scaleWidth.toPx(), visibleHeight),
            cornerRadius = CornerRadius(scaleCornerRadius.toPx())
        )

        // Малювання самого скролбару
        drawRoundRect(
            color = scrollBarColor,
            topLeft = Offset(this.size.width + 45, scrollBarOffsetY + 200),
            size = Size(scrollBarWidth.toPx(), scrollBarHeight),
            cornerRadius = CornerRadius(cornerRadius.toPx())
        )
    }
}

