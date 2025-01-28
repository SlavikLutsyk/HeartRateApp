package ua.example.pulseapp.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ua.example.pulseapp.R
import ua.example.pulseapp.ui.theme.BackGroundColor

@Composable
fun BackgroundImage(){
    Box(Modifier.fillMaxSize().background(BackGroundColor))
    Image(
        painter = painterResource(id = R.drawable.ellipse),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(650.dp),
        contentScale = ContentScale.FillBounds
    )
}