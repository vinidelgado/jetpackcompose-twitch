package com.vini.twitchexample.screens

import androidx.compose.foundation.Image
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vini.twitch.example.R
import com.vini.twitch.example.ui.theme.TwitchExampleTheme
import com.vini.twitch.example.ui.theme.md_theme_light_primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(key1 = true) {
                delay(3000L)
                navController.navigate("main")
            }
            LogoTwitch()
        }
    }
}

/*****************************************
 * Components
 *****************************************/
@Composable
fun LogoTwitch() {
    Image(
        painter = painterResource(id = R.drawable.ic_twitch_black),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .testTag("SplashScreenTwitchImage")
    )
}

/*****************************************
 * Preview
 *****************************************/
@Preview(
    name = "Pixel",
    showBackground = true,
    device = Devices.PIXEL_3A,
    group = "Pixel",
    uiMode = Configuration.UI_MODE_NIGHT_YES

)
@Composable
fun SplashScreenDefaultPreviewPixel() {
    val navController = rememberNavController()
    TwitchExampleTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            SplashScreen(navController)
        }
    }
}

@Preview(
    name = "Nexus5",
    showBackground = true,
    device = Devices.NEXUS_5,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    group = "Nexus5"
)
@Composable
fun SplashScreenDefaultPreviewNexus5() {
    TwitchExampleTheme {
        val navController = rememberNavController()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            SplashScreen(navController)
        }
    }
}