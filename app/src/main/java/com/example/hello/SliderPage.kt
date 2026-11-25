package com.example.hello

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar
import com.example.hello.ui.theme.colors
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun SliderPage(modifier: Modifier = Modifier, navController: NavController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)//menu open or closed
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "slider"
    )
    {
        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Slider",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) {
            Text("Slider")
            Spacer(modifier = Modifier.height(5.dp))
            var brightness by remember { mutableFloatStateOf(60f) }
            val sliderColors = SliderDefaults.colors(
                thumbColor = colors.primary,
                activeTrackColor = colors.primary,
                inactiveTrackColor = colors.light,
                activeTickColor = colors.white,      // step dots on the dragged (blue) part
                inactiveTickColor = colors.primary,  // step dots on the remaining (grey) part
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Brightness", modifier =
                        Modifier.weight(1f)
                )
                Text(
                    text = "${brightness.roundToInt()}%", color =
                        colors.primary
                )
            }
            Slider(
                value = brightness,
                onValueChange = { brightness = it },
                valueRange = 0f..100f,              // no steps: drag smoothly
                colors = sliderColors
            )

            Spacer(modifier = Modifier.height(24.dp))
            var fuel by remember { mutableFloatStateOf(50f) }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Fuel level", modifier =
                        Modifier.weight(1f)
                )
                Text(
                    text = "${fuel.roundToInt()}%", color =
                        colors.primary
                )
            } // close the Row here: the Row only holds the label + value
            Slider(
                value = fuel,
                onValueChange = { fuel = it },
                valueRange = 0f..100f,
                steps = 3,                          // 3 stops in the middle → 0, 25, 50, 75, 100
                colors = sliderColors
            )
        }
    }
}



