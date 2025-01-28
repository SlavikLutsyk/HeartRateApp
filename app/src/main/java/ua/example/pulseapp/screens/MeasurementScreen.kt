package ua.example.pulseapp.screens

import android.content.IntentSender
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.R
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.ui.theme.Blue
import ua.example.pulseapp.ui.theme.DarkGray
import ua.example.pulseapp.ui.theme.DarkWhite
import ua.example.pulseapp.ui.theme.White
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.utility.Loading
import ua.example.pulseapp.vectors.Heart

@Composable
fun MeasurementScreen(isActive: Boolean, onClosed: ()->Unit , onFinishedLoading: (result: HistoryResult)->Unit){
    BackgroundImage()
    if(!isActive)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, top = 8.dp), horizontalArrangement = Arrangement.End)
        {
            IconButton(onClick = onClosed, Modifier.scale(1.8f)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_close_14),
                    contentDescription = null, tint = DarkGray)
            }
        }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.camera),
            contentDescription = null,
            Modifier
                .clip(CircleShape)
                .width(42.dp)
                .height(42.dp)
                .border(2.dp, Blue, CircleShape)
        )

        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = if (!isActive) "Палець не виявлено." else "Йде Вимірювання.",
            fontWeight = FontWeight(600),
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp
        )
        Text(
            text = if (!isActive) "Щільно прикладіть палець до камери."
            else "Визначаємо ваш пульс. Утримуйте!",
            fontWeight = FontWeight(400),
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = DarkWhite
        )
        Spacer(modifier = Modifier.height(50.dp))
        Box(contentAlignment = Alignment.BottomCenter){
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberVectorPainter(image = Heart),
                    contentDescription = null,
                    modifier = Modifier.scale(0.95f)
                )
                Column{
                    Text(
                        text = "--",
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 62.sp,
                        color = White
                    )
                    Text(
                        text = "bpm",
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        color = White
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.heartshadow),
                contentDescription = null,
                Modifier.scale(1.5f)
            )
        }

        if (!isActive) {
            Spacer(modifier = Modifier.height(80.dp).fillMaxWidth())
            Image(painter = painterResource(id = R.drawable.camera),
                contentDescription = null, Modifier.scale(2.5f).offset(7.dp))
        }
        else{
            Spacer(modifier = Modifier.height(90.dp).fillMaxWidth())
            Loading(percentage = 0.99f, remember {mutableStateOf<Boolean>(true)}){}
        }
            
    }

}