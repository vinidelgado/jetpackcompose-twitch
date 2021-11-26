package com.vini.twitch.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.vini.twitch.example.helper.ScreenshotComparator
import com.vini.twitch.example.screens.MainScreen
import com.vini.twitch.example.ui.theme.TwitchExampleTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainScreenLayoutTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        composeTestRule.setContent {
            TwitchExampleTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    MainScreen(navController)
                }
            }
        }
    }

    @Test
    fun validateTitle() {
        val title = composeTestRule.onNode(hasText("Twitch’e Hoş Geldiniz"), false)
        title.assertIsDisplayed()
    }

    @Test
    fun validatePrimaryButton() {
        val button = composeTestRule.onNode(hasText("Oturum açın"), true)
        button.assertIsDisplayed()
        button.performClick()
    }

    @Test
    fun validateSecondaryButton() {
        val button = composeTestRule.onNode(hasText("Kaydol"), true)
        button.assertIsDisplayed()
        button.performClick()
    }

    @Test
    fun validateText() {
        validateTitle()
        validatePrimaryButton()
        validateSecondaryButton()
    }

    @Test
    fun validateMainScreenScreenshot() {
        ScreenshotComparator.assertScreenshot("main_screen", composeTestRule.onRoot())
    }
}