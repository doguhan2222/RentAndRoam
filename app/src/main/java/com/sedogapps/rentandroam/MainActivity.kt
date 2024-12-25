package com.sedogapps.rentandroam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sedogapps.rentandroam.presentation.features.onboard.OnboardingScreen
import com.sedogapps.rentandroam.presentation.features.splash.SplashScreen
import com.sedogapps.rentandroam.presentation.utils.ScreenDimensions
import com.sedogapps.rentandroam.ui.theme.RentAndRoamTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentAndRoamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*SplashScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    val configuration = LocalConfiguration.current
                    val screenWidth = configuration.screenWidthDp.dp
                    val screenHeight = configuration.screenHeightDp.dp

                    CompositionLocalProvider(// share screen dimensions to all
                        ScreenDimensions.screenWidth provides screenWidth,
                        ScreenDimensions.screenHeight provides screenHeight
                    ) {

                        OnboardingScreen()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RentAndRoamTheme {
        SplashScreen("Android")
    }
}