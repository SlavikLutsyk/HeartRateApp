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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.ui.theme.*

@Composable
fun HistoryCard(res: HistoryResult){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(HistoryCardWhite, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(Modifier.padding(start = 20.dp, end = 40.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = res.pulse.toString() + " BPM",
                fontWeight = FontWeight(400),
                fontSize = 36.sp,
                fontFamily = FontFamily.SansSerif)
            Box(modifier = Modifier
                .width(5.dp)
                .height(60.dp)
                .background(Red, CircleShape))
            Column() {
                Text(
                    text = res.time.substring(0, 4),
                    fontWeight = FontWeight(400),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = DarkGray
                )
                Text(
                    text = res.time.split(" ")[1],
                    fontWeight = FontWeight(400),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = DarkGray
                )
            }
        }
    }
}