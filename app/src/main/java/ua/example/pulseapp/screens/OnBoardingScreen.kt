package ua.example.pulseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.R
import ua.example.pulseapp.utility.BackgroundImage
import ua.example.pulseapp.utility.ScrollDots
import ua.example.pulseapp.utility.CustomButton

@Composable
fun OnBoardingScreen(onButtonClick: ()->Unit){
    val imageDrawables = listOf(R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3)

    val titles = listOf(stringResource(id = R.string.title1), stringResource(id = R.string.title2),
       stringResource(id = R.string.title3))

    val descriptions = listOf(
        stringResource(id = R.string.desc1), stringResource(id = R.string.desc2), stringResource(id = R.string.desc3)
    )
    val buttonTexts = listOf(stringResource(id = R.string.start),
        stringResource(id = R.string.moveOn), stringResource(id = R.string.start))

    val indexState = remember {
        mutableStateOf(0)
    }
    BackgroundImage()
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageDrawables[indexState.value]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 75.dp, end = 75.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = titles[indexState.value],
            fontWeight = FontWeight(600),
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
            )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = descriptions[indexState.value],
            fontWeight = FontWeight(400),
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = 22.dp, start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScrollDots(activeIndex = indexState)
            CustomButton(text = buttonTexts[indexState.value], indexState, onButtonClick)
        }
    }
}