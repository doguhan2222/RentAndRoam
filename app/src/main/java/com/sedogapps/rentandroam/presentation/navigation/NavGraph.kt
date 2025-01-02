package com.sedogapps.rentandroam.presentation.navigation


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sedogapps.rentandroam.presentation.features.login.LoginScreen
import com.sedogapps.rentandroam.presentation.features.onboard.OnboardingScreen
import com.sedogapps.rentandroam.presentation.features.splash.SplashScreen
import com.sedogapps.rentandroam.presentation.utils.ScreenRoutes


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Login.route
    ) {
        // Splash Screen to Onboard
        composable(ScreenRoutes.Splash.route,
            enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }) {
            SplashScreen( onNavigateToOnboard = {
                navController.navigate(ScreenRoutes.Onboard.route) {
                    popUpTo(ScreenRoutes.Splash.route) { inclusive = true } // Clear splash screen from stack
                }
            })

        }

        // Onboard Screen to Login
        composable(ScreenRoutes.Onboard.route, enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }) {
            OnboardingScreen(onNavigateToLogin = {
                navController.navigate(ScreenRoutes.Login.route) {
                    popUpTo(ScreenRoutes.Onboard.route) { inclusive = true } // Clear onboard screen from stack
                }
            })
        }

        // Login Screen
        composable(ScreenRoutes.Login.route) {
            LoginScreen()
        }


    }
}
