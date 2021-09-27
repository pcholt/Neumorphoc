package com.pcholt.neumorphoccalculator

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.pcholt.neumorphoccalculator.ui.theme.NeumorphocCalculatorTheme
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

class MainActivity : ComponentActivity() {

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(
            window, window.decorView
        ).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.hide(WindowInsetsCompat.Type.displayCutout())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    override fun onStart() {
        super.onStart()
//        hideSystemUI()
    }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeumorphocCalculatorTheme {
                InputPanel()
            }
        }
    }

}


@ExperimentalMaterialApi
@Composable
private fun InputPanel() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Row {
                CircleButton(displayText = "7")
                CircleButton(displayText = "8")
                CircleButton(displayText = "9")
            }
            Row {
                CircleButton(displayText = "4")
                CircleButton(displayText = "5")
                CircleButton(displayText = "6")
            }
            Row {
                CircleButton(displayText = "1")
                CircleButton(displayText = "2")
                CircleButton(displayText = "3")
            }
            Row {
                CircleButton(displayText = "0")
                CircleButton(displayText = "00")
                CircleButton(displayText = "<")
            }
            Row {
                ChargeButton(displayText = "Charge")
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun ChargeButton(displayText: String) {
    Card(
        backgroundColor = (MaterialTheme.colors.background),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .offset(x = 0.dp)
            .background(MaterialTheme.colors.background)
            .padding(bottom = 8.dp, top = 16.dp)
            .height(90.dp)
            .width(300.dp)
            .neumorphic()
    ) {
        Surface(onClick = {}, indication = rememberRipple()) {
            Text(
                text = displayText,
                color = MaterialTheme.colors.onPrimary,
                fontFamily = FontFamily.Monospace,
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Medium
                ),
                fontSize = 56.sp,
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun CircleButton(displayText: String) {
    Card(
        backgroundColor = (MaterialTheme.colors.background),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .offset(x = 0.dp)
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .size(90.dp, 90.dp)
            .neumorphic()
    ) {
        Surface(onClick = {}, indication = rememberRipple()) {
            Text(
                text = displayText,
                fontFamily = FontFamily.Monospace,
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Black
                ),
                fontSize = 56.sp,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun FullPanelPreview() {

    NeumorphocCalculatorTheme {
        InputPanel()
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NeumorphocCalculatorTheme {
        Column {
            CircleButton(displayText = "1")
            CircleButton(displayText = "2")
            CircleButton(displayText = "3")
        }
    }
}