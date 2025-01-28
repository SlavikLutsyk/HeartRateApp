package ua.example.pulseapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceView
import android.view.TextureView
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import net.kibotu.heartrateometer.HeartRateOmeter
import ua.example.pulseapp.navigation.HeartApp
import ua.example.pulseapp.screens.MeasurementScreen
import ua.example.pulseapp.screens.OnBoardingScreen
import ua.example.pulseapp.ui.theme.PulseAppTheme
import ua.example.pulseapp.utility.Camera2Helper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PulseAppTheme {
                //HeartApp(navHostController = rememberNavController(), context = this)

                HeartRateApp()

            }
        }
    }
}

@Composable
fun HeartRateApp() {
    var hasCameraPermission by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasCameraPermission = isGranted
    }

    // Check the permission when the composable is launched
    LaunchedEffect(Unit) {
        hasCameraPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    if (hasCameraPermission) {
        HeartRateScreen(context)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Camera permission is required to monitor your heart rate.")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }) {
                Text("Grant Camera Permission")
            }
        }
    }
}

@Composable
fun HeartRateScreen(context: Context) {
    var bpm by remember { mutableStateOf(0) }
    var textureView: TextureView? by remember { mutableStateOf(null) }

    // This is where we configure the camera using Camera2
    LaunchedEffect(textureView) {
        textureView?.let { view ->
            Camera2Helper(context, view) { calculatedBpm ->
                bpm = calculatedBpm
            }.startCamera()
        }
    }

    // UI for displaying heart rate with TextureView
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Display the BPM value
        Text(text = "$bpm bpm", style = MaterialTheme.typography.h1)

        // Integrate the TextureView inside the Compose UI
        AndroidView(
            factory = { ctx ->
                TextureView(ctx).also { textureView = it }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PulseAppTheme {

    }
}