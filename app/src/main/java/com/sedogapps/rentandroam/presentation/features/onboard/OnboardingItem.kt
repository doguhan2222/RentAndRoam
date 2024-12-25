package com.sedogapps.rentandroam.presentation.features.onboard

import androidx.compose.ui.text.AnnotatedString

data class OnboardingItem(
    val imageLight: Int, // For dark mode image
    val imageDark: Int, // For light mode image
    val title: AnnotatedString,
    val description: String
)
