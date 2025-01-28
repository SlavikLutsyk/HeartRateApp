package ua.example.pulseapp.utility

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.example.pulseapp.ui.theme.Red
import ua.example.pulseapp.ui.theme.White

@Composable
fun CustomButton(text: String, index: MutableState<Int> = mutableStateOf(3), onButtonClick: ()->Unit){
    Button(
        onClick = {if (index.value > 2) onButtonClick else index.value = index.value + 1},
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Red),
        modifier = Modifier.height(40.dp).fillMaxWidth()
    ) {
        Text(
            text = text,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            color = White
        )
    }
}