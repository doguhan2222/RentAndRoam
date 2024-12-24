package com.sedogapps.rentandroam.presentation.features

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test
import com.sedogapps.rentandroam.R

class SplashScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun splashScreenDisplaysCorrectly() {
        composeTestRule.setContent {
            SplashScreen(name = "Test User")
        }

        // Görsel kontrol: İlk resmin varlığını doğrula
        composeTestRule
            .onNodeWithContentDescription("Example PNG Image")
            .assertExists()

        // Get Started butonunun varlığını kontrol et
        composeTestRule
            .onNodeWithText("Get Started")
            .assertExists()
    }

    @Test
    fun roundedButtonClickWorks() {
        var clicked = false

        composeTestRule.setContent {
            RoundedButton(text = "Click Me") { clicked = true }
        }

        // Butonun varlığını kontrol et
        composeTestRule
            .onNodeWithText("Click Me")
            .assertExists()

        // Butona tıklamayı simüle et
        composeTestRule
            .onNodeWithText("Click Me")
            .performClick()

        // Tıklamanın sonucunu doğrula
        assert(clicked)
    }

    @Test
    fun roundedButtonUpdatesStateOnClick() {
        var clicked = false
        composeTestRule.setContent {
            RoundedButton(text = "Click Me") { clicked = true }
        }

        // Tıklamadan önce durumun false olduğunu doğrula
        assert(!clicked)

        // Butona tıkla
        composeTestRule
            .onNodeWithText("Click Me")
            .performClick()

        // Tıklamadan sonra durumun true olduğunu doğrula
        assert(clicked)
    }


    @Test
    fun roundedButtonHasCorrectAccessibilityRole() {
        composeTestRule.setContent {
            RoundedButton(text = "Click Me") {}
        }

        // Butonun rolünün doğru olduğunu doğrula
        composeTestRule
            .onNodeWithText("Click Me")
            .assertHasClickAction()
            .assertIsEnabled()
            .assert(
                hasContentDescription("Click Me")
            )
    }


    @Test
    fun roundedButtonDisabledState() {
        composeTestRule.setContent {
            Button(
                onClick = {},
                enabled = false // Butonun pasif durumu
            ) {
                Text("Disabled")
            }
        }

        // Butonun devre dışı olduğunu doğrula
        composeTestRule
            .onNodeWithText("Disabled")
            .assertIsNotEnabled()
    }


    @Test
    fun roundedButtonTriggersAnotherAction() {
        var message by mutableStateOf("Initial State")

        composeTestRule.setContent {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoundedButton(text = "Click Me") { message = "Button Clicked!" }
                Text(
                    text = message,
                    modifier = Modifier.padding(16.dp),
                    // Make sure text is visible
                    color = Color.Black
                )
            }
        }

        // Print semantic tree for debugging
        composeTestRule.onRoot().printToLog("TEST_TAG")

        // Verify initial state
        composeTestRule
            .onNodeWithText("Initial State")
            .assertIsDisplayed()

        // Click the button
        composeTestRule
            .onNodeWithText("Click Me")
            .performClick()

        composeTestRule.waitForIdle()

        // Print semantic tree again after click
        composeTestRule.onRoot().printToLog("TEST_TAG")

        // Try with different assertions to narrow down the issue
        composeTestRule
            .onNodeWithText("Button Clicked!")
            .assertExists() // First verify it exists
            .assertIsEnabled() // Then check if it's enabled
            .assertIsDisplayed() // Finally check if it's displayed
    }
    @Test
    fun testButtonWithAnimation() {
        composeTestRule.mainClock.autoAdvance = false // Animasyonu manuel kontrol edin

        composeTestRule.setContent {
            AnimatedVisibility(visible = true) {
                RoundedButton(text = "Animated Button") {}
            }
        }

        // İlk animasyon durumunu kontrol et
        composeTestRule
            .onNodeWithText("Animated Button")
            .assertExists()

        // Animasyonu ileri sar
        composeTestRule.mainClock.advanceTimeBy(1000) // 1 saniye

        // Final durumunu kontrol et
        composeTestRule
            .onNodeWithText("Animated Button")
            .assertExists()
    }

    @Test
    fun buttonHandlesNullClickActionGracefully() {
        composeTestRule.setContent {
            RoundedButton(text = "Click Me", onClick = {})
        }

        // Butona tıkla ve herhangi bir hata olmadığından emin ol
        composeTestRule
            .onNodeWithText("Click Me")
            .performClick()
    }





}
