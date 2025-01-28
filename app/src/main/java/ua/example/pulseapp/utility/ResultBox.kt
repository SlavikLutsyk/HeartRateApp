package ua.example.pulseapp.utility

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.R
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.ui.theme.*


@Composable
fun ResultBox(res: HistoryResult){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(White, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Column() {
                    Text(
                        text = "Ваш Результат",
                        fontWeight = FontWeight(500),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.padding(bottom = 7.dp)
                    )

                    Text(
                        text = if(res.pulse<60) "Уповільнений"
                        else if (res.pulse>100) "Прискорений"
                        else "Звичайно",
                        fontWeight = FontWeight(700),
                        fontSize = 28.sp,
                        color = if(res.pulse<60) LightBlue
                        else if (res.pulse>100) Red
                        else Green
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_time_20),
                        contentDescription = null, tint = DarkGray)
                    Column() {
                        Text(
                            text = res.time.substring(0, 4),
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = DarkGray
                        )
                        Text(
                            text = res.time.split(" ")[1],
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = DarkGray
                        )
                    }
                }
            }
            Slider(bpm = res.pulse)
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                MeasurementLabel(color = LightBlue, title = "Уповільнений")
                Text(
                    text = "<60 BPM",
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = if(res.pulse<60) Color.Black else DarkGray
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                MeasurementLabel(color = Green, title = "Звичайно")
                Text(
                    text = "60-100 BPM",
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = if(res.pulse in 60..100) Color.Black else DarkGray
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                MeasurementLabel(color = Red, title = "Прискорений")
                Text(
                    text = ">100 BPM",
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = if(res.pulse>100) Color.Black else DarkGray
                )
            }
        }
    }
}