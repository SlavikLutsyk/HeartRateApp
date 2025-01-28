package ua.example.pulseapp.vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Heart = ImageVector.Builder(
    name = "Heart",
    defaultWidth = 286.dp,
    defaultHeight = 260.dp,
    viewportWidth = 286f,
    viewportHeight = 260f
).apply {
    path(
        fill = Brush.linearGradient(
            colors = listOf(Color(0xFFFE6B91), Color(0xFFFF1D29)),
            start = Offset(143f, 6f),
            end = Offset(143f, 246f)
        ),
        pathFillType = PathFillType.NonZero
    ) {
        moveTo(254.478f, 32.1074f)
        curveTo(239.057f, 15.6121f, 218.187f, 6.35223f, 195.728f, 6.01028f)
        curveTo(176.109f, 5.6273f, 157.889f, 20.0436f, 142.997f, 32.1074f)
        curveTo(128.106f, 20.0573f, 109.574f, 5.55892f, 90.2939f, 6.01028f)
        curveTo(67.8348f, 6.35223f, 46.9789f, 15.6121f, 31.5442f, 32.1074f)
        curveTo(1.3542f, 64.3869f, 3.10691f, 117.142f, 35.4573f, 149.709f)
        lineTo(122.712f, 237.547f)
        curveTo(128.31f, 243.182f, 135.66f, 246f, 142.997f, 246f)
        curveTo(150.334f, 246f, 157.698f, 243.182f, 163.283f, 237.547f)
        lineTo(250.537f, 149.709f)
        curveTo(282.888f, 117.142f, 284.654f, 64.3869f, 254.45f, 32.1074f)
        close()
    }

    group(
        translationX = 15.95f,
        translationY = 22.92f
    ){
        path(
            fill = Brush.linearGradient(
                colors = listOf(Color(0xFFFE8F9F), Color(0xFFFF506D)),
                start = Offset(79.5f, -4.51f),
                end = Offset(2.99f, 66.98f)
            ),
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(96.9989f, 11.49f)
            curveTo(95.4989f, 24.4906f, 77.5601f, 23.2288f, 63.5f, 24.9907f)
            curveTo(48f, 25.6583f, 26.0661f, 41.7035f, 21.9989f, 46.9917f)
            curveTo(12f, 59.9923f, 5.49968f, 80.0597f, 0.999837f, 75.4931f)
            curveTo(-0.50008f, 62.6601f, 32.499f, 0.923096f, 76.499f, 0.923096f)
            curveTo(86.4402f, 0.923096f, 96.9989f, 3.48963f, 96.9989f, 11.49f)
            close()
        }
    }
}.build()