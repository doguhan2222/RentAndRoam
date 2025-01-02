package com.sedogapps.rentandroam.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ),
    textColor: Color = Color.White,
    fontSize: TextUnit = 16.sp,
    shape: RoundedCornerShape = RoundedCornerShape(
        8.dp
    ),
    contentPadding: PaddingValues = PaddingValues(
        16.dp
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier.semantics {
            contentDescription = text
        },
        colors = colors,
        shape = shape,
        contentPadding = contentPadding
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}