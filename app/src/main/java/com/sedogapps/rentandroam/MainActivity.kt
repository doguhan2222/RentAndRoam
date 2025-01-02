package com.sedogapps.rentandroam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.sedogapps.rentandroam.presentation.navigation.NavGraph
import com.sedogapps.rentandroam.presentation.utils.ScreenDimensions
import com.sedogapps.rentandroam.ui.theme.RentAndRoamTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentAndRoamTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    // Ekran boyutlarını hesapla ve paylaş
                    val configuration = LocalConfiguration.current
                    val screenWidth = configuration.screenWidthDp.dp
                    val screenHeight = configuration.screenHeightDp.dp

                    CompositionLocalProvider(
                        ScreenDimensions.screenWidth provides screenWidth,
                        ScreenDimensions.screenHeight provides screenHeight
                    ) {
                        // Navigation Controller tanımla
                        val navController = rememberNavController()

                        // NavGraph'i çalıştır
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RentAndRoamTheme {
        SplashScreen()
    }
}*/
