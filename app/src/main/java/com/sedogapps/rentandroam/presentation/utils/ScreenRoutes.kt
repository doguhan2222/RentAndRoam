package com.sedogapps.rentandroam.presentation.utils


sealed class ScreenRoutes(val route: String) {
    object Splash : ScreenRoutes("splash")
    object Onboard : ScreenRoutes("onboard")
    object Login : ScreenRoutes("login")
    object Register : ScreenRoutes("register")

}
