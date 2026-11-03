package com.example.hello


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.hello.ui.components.card.AppCard
import com.example.hello.ui.components.radio.AppRadioGroup
import com.example.hello.ui.components.layout.AppTopBar
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@Composable
fun RadioPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(
        modifier = modifier,
        scrollable = true,
        topBar = {
            AppTopBar(
                title = "Radio",
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }

                }
            )
        }
        ) {
        var selectedText by remember { mutableStateOf("Text 1") } //
        var selectedGroup by remember { mutableStateOf("Text 1") } //
        var selectedGroup2 by remember { mutableStateOf("Text 1") } //


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