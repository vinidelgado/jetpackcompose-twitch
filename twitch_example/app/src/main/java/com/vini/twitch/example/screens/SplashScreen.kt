package com.vini.twitch.example.screens

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
import androidx.compose.runtime.remember
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
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.ui.draw.scale
import kotlinx.coroutines.*

@Composable
fun SplashScreen(
    navController: NavHostController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {

    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(2000)
            navController.popBackStack()
            navController.navigate("main")
        }
    }

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
            Image(
                painter = painterResource(id = R.drawable.ic_twitch_black),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .scale(scale.value)
                    .testTag("SplashScreenTwitchImage")
            )
        }
    }
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