package com.example.hello

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.theme.colors
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.hello.ui.components.card.AppCard
import com.example.hello.ui.components.radio.AppRadioGroup

@Composable
fun RadioPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier, scrollable = true) {
        var selectedText by remember { mutableStateOf("Text 1") } //
        var selectedGroup by remember { mutableStateOf("Text 1") } //
        var selectedGroup2 by remember { mutableStateOf("Text 1") } //

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
                    )
                    { navController.navigate("template") }
            )
            Text(
                text = "Radio Page",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                enabled = false,
                selected = selectedText=="Text 1",
                onClick = {selectedText = "Text 1"}
            )
            Text("Text 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedText=="Text 2",
                onClick = {selectedText="Text 2"}
            )
            Text("TextTextTextTextTextTextTextTextTextTextTextTextText 2")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text("Size 1:")
        Spacer(modifier = Modifier.height(5.dp))
        AppCard(hasShadow = true) {
            AppRadioGroup(
                options = listOf("Text 1", "TextTextTextTextTextTextTextTextTextTextText 2","Text 3","Text 4"),
                selected = selectedGroup2,
                onSelectedChange = {selectedGroup2 = it }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Text("Size 2:")
        Spacer(modifier = Modifier.height(5.dp))
        AppCard(hasShadow = true) {
           AppRadioGroup(
               options = listOf("Text 4", "Text 5","Text 6","Text 7"),
               selected = selectedGroup,
               onSelectedChange = {selectedGroup = it },
               radioScale = 1.3f,
               gap = 12.dp
           )
        }

    }
}