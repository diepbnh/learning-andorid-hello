package com.example.hello

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hello.ui.components.layout.AppPage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.example.hello.ui.theme.colors
import com.example.hello.ui.theme.titleLarge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.hello.ui.components.checkbox.AppCheckbox
import androidx.compose.material3.Switch
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.card.AppCard
import com.example.hello.ui.components.toggle.AppSwitch
import com.example.hello.ui.theme.ThemeManager

@Composable
fun CheckboxPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier, scrollable = true) {

        var checked1 by remember { mutableStateOf(false) }
        var checked2 by remember { mutableStateOf(false) }
        var checked3 by remember { mutableStateOf(false) }
        var checked4 by remember { mutableStateOf(false) }
        var checked5 by remember { mutableStateOf(false) }
        var notify by remember { mutableStateOf(true) }

        var notification by remember { mutableStateOf(false) }
        var autoPlay by remember { mutableStateOf(false) }
        var acceptTerms by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Template",
                color = colors.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { navController.navigate("template") }

            )

            Text(
                text = "Checkbox Page",
                color = colors.primary,
                style = titleLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(35.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)//gap cac dong
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,//
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {

                    Checkbox(
                        checked = checked1,
                        onCheckedChange = { checked1 = it },//bấm lưu giá trị
                        colors = CheckboxDefaults.colors(
                            checkedColor = colors.primary,
                            uncheckedColor = colors.primary,
                            checkmarkColor = colors.white
                        )
                    )
                    Text(text = "Check")
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,//
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
                    Checkbox(
                        checked = checked2,
                        onCheckedChange = { checked2 = it },//bấm lưu giá trị
                        colors = CheckboxDefaults.colors(
                            checkedColor = colors.primary,
                            uncheckedColor = colors.primary,
                            checkmarkColor = colors.white
                        )
                    )
                    Text(text = "Check Trong Compose")
                }
            }
            Row() {
                Switch(
                    checked = notify,
                    onCheckedChange = { notify = it },
                )
                Switch(
                    checked = notify,
                    onCheckedChange = { notify = it },
                    modifier = Modifier.scale(0.8f)
                )
            }
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Component Checkbox trong composable",
                fontWeight= FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(35.dp))

            AppCheckbox(
                label = "Checkbox trong composable Checkbox trong composable ",
                checked = checked3,
                onCheckedChange = { checked3 = it },
            )
            AppCheckbox(
                label = "Checkbox  ",
                checked = checked4,
                onCheckedChange = { checked4 = it },
            )
            AppCheckbox(
                label = "Checkbox  ",
                checked = checked5,
                onCheckedChange = { checked5 = it },
            )

        }
        Spacer(modifier= Modifier.height(25.dp))
        AppCard(hasShadow = true) {

            AppSwitch(
                label = "Dark Mode",
                checked = ThemeManager.isDarkMode.value,//đọc theme hiên tại
                onCheckedChange = { ThemeManager.setDarkMode(it) },//đổi theme cả app
            )

            AppSwitch(
                label = "Notification",
                checked = notification,
                onCheckedChange = { notification = it},
            )
            AppSwitch(
                label = "Auto play video Auto play video Aut",
                checked = autoPlay,
                onCheckedChange = { autoPlay = it },
            )
        }
        Spacer(modifier= Modifier.height(25.dp))

        AppCheckbox(
            label = "I accept the terms and conditions",
            checked = acceptTerms,
            onCheckedChange = {acceptTerms=it},
            textColor = colors.primary
        )
        Spacer(modifier= Modifier.height(25.dp))
        AppButton(
            text = "Save",
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )

    }
}
