package ua.example.pulseapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.zIndex
import ua.example.pulseapp.R
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.ui.theme.LightRed
import ua.example.pulseapp.ui.theme.Red
import ua.example.pulseapp.ui.theme.White
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.utility.CustomButton
import ua.example.pulseapp.utility.HistoryCard
import ua.example.pulseapp.utility.verticalScrollbar

@Composable
fun HistoryScreen(historyList: List<HistoryResult>, onBackClicked: ()->Unit, onButtonClick: ()->Unit){
    val scrollState = rememberScrollState()
    BackgroundImage()
    TopAppBar(
        backgroundColor = Red,
        contentColor = White,
        modifier = Modifier.zIndex(1.5f)
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(onClick = onBackClicked) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = null,
                modifier = Modifier.scale(1.0f)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            "Історія",
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif
        )
    }
    Column(
        Modifier
            .padding(start = 10.dp, end = 25.dp, bottom = 22.dp,)
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .verticalScrollbar(scrollState, scrollBarColor = Red, scaleColor = LightRed)
            .zIndex(0.9f)
    ) {
        Spacer(modifier = Modifier.padding(top = 70.dp))
        for (item in historyList){
            HistoryCard(res = item)
            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(text = "Очистити історію", onButtonClick =  onButtonClick)
        }
    }

}

