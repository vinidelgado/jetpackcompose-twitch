package com.vini.twitch.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.LargeTest
import com.vini.twitch.example.helper.ScreenshotComparator
import com.vini.twitch.example.ui.theme.TwitchExampleTheme
import com.vini.twitch.example.screens.SplashScreen
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test


@LargeTest
class SplashScreenLayoutTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        composeTestRule.setContent {
            TwitchExampleTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SplashScreen(navController)
                }
            }
        }
    }

    @Test
    fun validateTwitchIconAppear() {
        val imageLogo = composeTestRule.onNode(
            hasTestTag("SplashScreenTwitchImage"),
            useUnmergedTree = true
        )
        imageLogo.assertIsDisplayed()
    }

    @Ignore
    @Test
    fun validateSplashScreenScreenshot() {
        val imageLogo = composeTestRule.onNode(
            hasTestTag("SplashScreenTwitchImage"),
            useUnmergedTree = true
        )
        imageLogo.assertIsDisplayed()
        ScreenshotComparator.assertScreenshot("splash_screen", composeTestRule.onRoot())
    }
}