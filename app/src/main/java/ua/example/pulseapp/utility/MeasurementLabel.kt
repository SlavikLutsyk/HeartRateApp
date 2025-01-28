package ua.example.pulseapp.utility

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.ui.theme.LightBlue2

@Composable
fun MeasurementLabel(color: Color, title: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .width(150.dp).height(20.dp)
            .background(LightBlue2, RoundedCornerShape(3.dp))
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .clip(CircleShape)
                .background(color, CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            fontWeight = FontWeight(400),
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif
        )
    }
}