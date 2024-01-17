package __GROUP_NAME__

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.highcapable.betterandroid.compose.multiplatform.systembar.PlatformSystemBarStyle
import com.highcapable.betterandroid.compose.multiplatform.systembar.PlatformSystemBars
import com.highcapable.betterandroid.compose.multiplatform.systembar.rememberSystemBarsController
import com.highcapable.betterandroid.compose.multiplatform.systembar.setStyle
import com.highcapable.flexiui.FlexiTheme
import com.highcapable.flexiui.component.AreaColumn
import com.highcapable.flexiui.component.Button
import com.highcapable.flexiui.component.PrimaryAppBar
import com.highcapable.flexiui.component.Scaffold
import com.highcapable.flexiui.component.Text
import com.highcapable.flexiui.defaultColors

@Composable
private fun MyApplicationTheme(content: @Composable () -> Unit) {
    val systemBars = rememberSystemBarsController()
    val currentDarkMode = isSystemInDarkTheme()
    val colorScheme = defaultColors(currentDarkMode)
    systemBars.setStyle(
        if (currentDarkMode)
            PlatformSystemBarStyle.DarkTransparent
        else PlatformSystemBarStyle.LightTransparent
    )
    // Customize Flexi UI theme styles.
    FlexiTheme(
        colors = colorScheme,
        content = content
    )
}

// Generated by https://github.com/BetterAndroid/compose-multiplatform-template
// You can visit https://github.com/BetterAndroid/FlexiUI to learn how to use Flexi UI.
@Composable
fun App() {
    MyApplicationTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        appBar = {
            PrimaryAppBar(
                title = { Text("__APP_NAME__") }
            )
        }
    ) { innerPadding ->
        val systemBars = rememberSystemBarsController()
        var hideOrShowBars by remember { mutableStateOf(false) }
        var greeting by remember { mutableStateOf("Hello World!") }
        AreaColumn(
            modifier = Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = greeting)
            NecessarySpacer()
            Button(
                onClick = { greeting = "Hello Jetpack Compose Multiplatform!" }
            ) { Text("Greeting") }
            NecessarySpacer()
            Button(
                onClick = { hideOrShowBars = !hideOrShowBars }
            ) { Text("Trigger SystemBars") }
        }
        LaunchedEffect(hideOrShowBars) {
            if (hideOrShowBars)
                systemBars.hide(PlatformSystemBars.All)
            else systemBars.show(PlatformSystemBars.All)
        }
    }
}

@Composable
private fun NecessarySpacer() {
    Spacer(Modifier.height(20.dp))
}