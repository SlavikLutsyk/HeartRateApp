package ua.example.pulseapp.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.R
import ua.example.pulseapp.ui.theme.Red
import ua.example.pulseapp.ui.theme.White
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.vectors.HeartBeat

@Composable
fun HomePageScreen(context: Context, onButtonClicked: ()->Unit, onHistoryClicked: ()->Unit){
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    BackgroundImage()
    TopAppBar(
        backgroundColor = Red,
        contentColor = White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "Історія",
                fontWeight = FontWeight(400),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = onHistoryClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_history_24),
                    contentDescription = null,
                    modifier = Modifier.scale(1.8f)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (sharedPreferences.getBoolean("firstTime", true))
            Text(
                "Виконайте своє перше\n" +
                        "вимірювання!",
                fontWeight = FontWeight(700),
                fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
        else
            Spacer(modifier = Modifier.height(60.dp))
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = rememberVectorPainter(image = HeartBeat),
            contentDescription = null,
            modifier = Modifier.scale(0.95f)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = 42.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onButtonClicked, modifier = Modifier.scale(2.5f)) {
                Image(painter = painterResource(id = R.drawable.startmeasurementbutton),
                    contentDescription = null)
            }
        }
    }
}