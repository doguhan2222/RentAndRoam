package com.sedogapps.rentandroam.presentation.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sedogapps.rentandroam.R
import com.sedogapps.rentandroam.presentation.utils.ScreenDimensions


@Composable
fun SplashScreen(
    name: String,
    modifier: Modifier = Modifier
) {
    val screenWidth = ScreenDimensions.screenWidth.current
    val screenHeight = ScreenDimensions.screenHeight.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            (screenHeight.value * 0.075).dp
        )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.splash_background
            ),
            contentDescription = stringResource(id = R.string.splash_background_image_desc),
            contentScale = ContentScale.FillWidth,

            modifier = Modifier
                .width(
                    (screenWidth.value).dp
                )
                .height(
                    (screenHeight.value * 0.45).dp
                )
        )
        Image(
            painter = painterResource(
                id = R.drawable.splash_logo
            ),
            contentDescription = stringResource(id = R.string.splash_logo_image_desc),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(
                    (screenWidth.value * 0.6).dp
                )
                .height(
                    (screenHeight.value * 0.25).dp
                )

        )
        RoundedButton(
            text = stringResource(id = R.string.splash_get_started),
            onClick = { /* Butona tıklandığında yapılacak işlemler */ }
        )
    }
}


@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit
) {


    val screenWidth = ScreenDimensions.screenWidth.current
    val screenHeight = ScreenDimensions.screenHeight.current



    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(
                dimensionResource(R.dimen.splash_button_padding),
                0.dp,
                dimensionResource(R.dimen.splash_button_padding),
                0.dp
            )
            .fillMaxWidth().semantics { contentDescription = text },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(
            dimensionResource(R.dimen.splash_button_corner_radius)
        ),
        contentPadding = PaddingValues(
            dimensionResource(R.dimen.splash_content_padding),
        )
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = (screenWidth.value * 0.05).sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
