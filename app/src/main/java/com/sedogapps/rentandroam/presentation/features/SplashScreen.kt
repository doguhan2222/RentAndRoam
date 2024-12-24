package com.sedogapps.rentandroam.presentation.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sedogapps.rentandroam.R


@Composable
fun SplashScreen(
    name: String,
    modifier: Modifier = Modifier
) {
    val configuration =
        LocalConfiguration.current
    val screenWidth =
        configuration.screenWidthDp // Ekranın genişliği
    val screenHeight =
        configuration.screenHeightDp // Ekranın yüksekliği

    Column(
        modifier = Modifier.fillMaxSize(), // Kolonun ekranın tamamını kaplamasını sağlıyoruz
        horizontalAlignment = Alignment.CenterHorizontally, // Column içinde tüm öğeleri yatayda ortala\
        verticalArrangement = Arrangement.spacedBy(
            (screenHeight * 0.075).dp
        )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.getstartedbackground
            ),
            contentDescription = "Example PNG Image",
            contentScale = ContentScale.FillWidth,

            modifier = Modifier
                .width(
                    (screenWidth).dp
                ) // Ekran genişliğinin %100'ü
                .height(
                    (screenHeight * 0.58).dp
                ) // Ekran yüksekliğinin %58'i
        )
        Image(
            painter = painterResource(
                id = R.drawable.resimtest2
            ),
            contentDescription = "Example PNG Image2",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(
                    (screenWidth * 0.6).dp
                ) // Ekran genişliğinin %60'ı
                .height(
                    (screenHeight * 0.1).dp
                ) // Ekran yüksekliğinin %30'u

        )
        RoundedButton(
            text = "Get Started",
            onClick = { /* Butona tıklandığında yapılacak işlemler */ }
        )
    }
}


@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit
) {


    val configuration =
        LocalConfiguration.current
    val screenWidth =
        configuration.screenWidthDp // Ekranın genişliği
    val screenHeight =
        configuration.screenHeightDp // Ekranın yüksekliği



    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(
                25.dp,
                0.dp,
                25.dp,
                0.dp
            )
            .fillMaxWidth().semantics { contentDescription = text }, // Butonun genişliğini ekranın tamamına yayalım
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary, // Temadan alınan arka plan rengi
            contentColor = MaterialTheme.colorScheme.onPrimary // Temadan alınan metin rengi
        ),
        shape = RoundedCornerShape(
            60.dp
        ), // Köşeleri yuvarlayalım
        contentPadding = PaddingValues(
            16.dp
        ) // İçeriğe biraz boşluk ekleyelim
    ) {
        Text(
            text = text, // Butonun yazısını alıyoruz
            color = Color.White, // Yazı rengini beyaz yapıyoruz
            fontSize = (screenWidth * 0.05).sp,
            style = MaterialTheme.typography.bodyLarge // Buton yazı tipini ayarlıyoruz
        )
    }
}
