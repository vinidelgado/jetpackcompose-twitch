package com.vini.twitch.example.screens

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vini.twitch.example.R
import com.vini.twitch.example.ui.theme.TwitchExampleTheme
import com.vini.twitch.example.ui.theme.md_theme_dark_inverseOnSurface
import com.vini.twitch.example.ui.theme.md_theme_dark_onPrimary
import com.vini.twitch.example.ui.theme.md_theme_dark_onSurface
import com.vini.twitch.example.ui.theme.md_theme_dark_onSurfaceVariant
import com.vini.twitch.example.ui.theme.md_theme_light_inverseOnSurface
import com.vini.twitch.example.ui.theme.md_theme_light_onSurface
import com.vini.twitch.example.ui.theme.md_theme_light_onSurfaceVariant
import com.vini.twitch.example.ui.theme.md_theme_light_primary
import com.vini.twitch.example.ui.theme.typographyTwitch

@Composable
fun MainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainTitle()
            Spacer(Modifier.height(40.dp))
            TwitchPrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                stringResource(id = R.string.welcome_primary_button_label)
            )
            Spacer(Modifier.height(8.dp))
            TwitchSecondaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                stringResource(id = R.string.welcome_secondary_button_label)
            )
        }
    }
}

/*****************************************
 * Components
 *****************************************/
@Composable
fun MainTitle() {
    Text(
        stringResource(id = R.string.welcome_message),
        style = typographyTwitch.displayMedium,
        textAlign = TextAlign.Center,
        color = if (isSystemInDarkTheme()) {
            md_theme_dark_onSurface
        } else {
            md_theme_light_onSurface
        }
    )
}

@Composable
fun TwitchPrimaryButton(modifier: Modifier = Modifier, text: String) {
    val color = if (isSystemInDarkTheme()) {
        md_theme_dark_onPrimary
    } else {
        md_theme_light_primary
    }
    val textColor = Color.White
    TwitchButton(backgroundColor = color, text = text, textColor = textColor, modifier = modifier)
}

@Composable
fun TwitchSecondaryButton(modifier: Modifier = Modifier, text: String) {
    val color = if (isSystemInDarkTheme()) {
        md_theme_dark_inverseOnSurface
    } else {
        md_theme_light_inverseOnSurface
    }
    val textColor = if (isSystemInDarkTheme()) {
        md_theme_dark_onSurfaceVariant
    } else {
        md_theme_light_onSurfaceVariant
    }
    TwitchButton(backgroundColor = color, text = text, textColor = textColor, modifier = modifier)
}


@Composable
private fun TwitchButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    text: String,
    textColor: Color
) {
    FilledTonalButton(
        onClick = {},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.Red,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f),
            disabledContentColor = Color.White
        )
    ) {
        Text(
            style = typographyTwitch.labelMedium,
            color = textColor,
            text = if (text.isEmpty()) {
                stringResource(id = R.string.welcome_primary_button_label)
            } else {
                text
            }
        )
    }
}

/***
 * Preview
 */
@Preview(
    name = "Pixel",
    showBackground = true,
    device = Devices.PIXEL_3A,
    group = "Pixel",
    uiMode = Configuration.UI_MODE_NIGHT_YES

)
@Composable
fun DefaultPreviewPixel() {
    val navController = rememberNavController()
    TwitchExampleTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            MainScreen(navController)
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
fun DefaultPreviewNexus5() {
    val navController = rememberNavController()
    TwitchExampleTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            MainScreen(navController)
        }
    }
}