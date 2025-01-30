package com.sedogapps.rentandroam.presentation.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sedogapps.rentandroam.R
import com.sedogapps.rentandroam.presentation.common.RoundedButton
import com.sedogapps.rentandroam.presentation.utils.ScreenDimensions
import com.sedogapps.rentandroam.ui.theme.RentAndRoamTheme


@Composable
fun LoginScreen (

) {
    val screenWidth = ScreenDimensions.screenWidth.current
    val screenHeight = ScreenDimensions.screenHeight.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            (screenHeight.value * 0.075).dp
        )
    ){
        Spacer(modifier = Modifier.height(
            dimensionResource(R.dimen.login_spacer_height)
        ))
        Image(
            painter = painterResource(
                id = R.drawable.splash_logo
            ),
            contentDescription = stringResource(
                id = R.string.logo_image_desc
            ),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(
                    (screenWidth.value * 0.55).dp
                )
                .height(
                    (screenHeight.value * 0.2).dp
                )


        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.login_sigin),
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.login_content_padding)
                )
            )
        }
        UsernameEditText(
            value = username,
            onValueChange = { username = it }
        )
        PasswordEditText(
            value = password,
            onValueChange = { password = it }
        )
        RoundedButton(
            text = stringResource(
                id = R.string.splash_get_started
            ),
            onClick = {

            },
            modifier = Modifier
                .padding(
                    dimensionResource(
                        R.dimen.splash_button_padding
                    ),
                    0.dp,
                    dimensionResource(
                        R.dimen.splash_button_padding
                    ),
                    0.dp
                )
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            textColor = Color.White,
            shape = RoundedCornerShape(
                dimensionResource(
                    R.dimen.splash_button_corner_radius
                )
            ),
            contentPadding = PaddingValues(
                dimensionResource(
                    R.dimen.splash_content_padding
                ),
            ),
            fontSize = (screenWidth.value * 0.05).sp,
        )

    }
}

@Composable
fun UsernameEditText(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.login_username)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(id = R.string.login_username)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun PasswordEditText(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.login_password)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(id = R.string.login_password)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium
    )
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RentAndRoamTheme {
        LoginScreen()
    }
}
