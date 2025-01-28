package ua.example.pulseapp.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.group

val HeartBeat = ImageVector.Builder(
    name = "HeartBeat",
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
        translationX = 0f,
        translationY = 72f
    ){
        path(
            fill = SolidColor(Color.White),
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(273.063f, 44.4176f)
            lineTo(193.474f, 44.4176f)
            curveTo(184.925f, 44.4176f, 177.003f, 48.7386f, 172.27f, 55.9453f)
            lineTo(159.847f, 74.872f)
            lineTo(137.784f, 7.61481f)
            curveTo(136.459f, 3.60454f, 133.007f, 0.689327f, 128.871f, 0.127001f)
            curveTo(124.75f, -0.524113f, 120.657f, 1.44402f, 118.327f, 4.96596f)
            lineTo(93.5259f, 42.775f)
            curveTo(92.8414f, 43.8109f, 91.72f, 44.4176f, 90.4967f, 44.4176f)
            lineTo(10.9225f, 44.4176f)
            curveTo(4.89329f, 44.4176f, 0f, 49.3897f, 0f, 55.5161f)
            curveTo(0f, 61.6425f, 4.89329f, 66.6147f, 10.9225f, 66.6147f)
            lineTo(90.5113f, 66.6147f)
            curveTo(99.06f, 66.6147f, 106.982f, 62.2936f, 111.715f, 55.087f)
            lineTo(124.138f, 36.1603f)
            lineTo(146.202f, 103.417f)
            curveTo(147.527f, 107.428f, 150.978f, 110.343f, 155.114f, 110.905f)
            curveTo(155.595f, 110.979f, 156.076f, 111.009f, 156.571f, 111.009f)
            curveTo(160.197f, 111.009f, 163.605f, 109.174f, 165.658f, 106.066f)
            lineTo(190.46f, 68.2572f)
            curveTo(191.144f, 67.2214f, 192.265f, 66.6147f, 193.489f, 66.6147f)
            lineTo(273.077f, 66.6147f)
            curveTo(279.107f, 66.6147f, 284f, 61.6425f, 284f, 55.5161f)
            curveTo(284f, 49.3897f, 279.092f, 44.4176f, 273.063f, 44.4176f)
            close()
        }
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
