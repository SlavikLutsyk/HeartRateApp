package ua.example.pulseapp.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.R
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.ui.theme.Red
import ua.example.pulseapp.ui.theme.White
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.utility.CustomButton
import ua.example.pulseapp.utility.ResultBox

@Composable
fun ResultScreen(context: Context, res: HistoryResult, onHistoryClicked: ()->Unit, onButtonClick: ()->Unit){
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    sharedPreferences.getBoolean("firstTime", false)
    BackgroundImage()
    TopAppBar(
        backgroundColor = Red,
        contentColor = White
    ) {
        Text(
            text = "Результат",
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif
        )
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(top = 250.dp)
    ) {
        ResultBox(res = res)
        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = 22.dp, start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(text = "Готово", onButtonClick = onButtonClick)
        }
    }
}