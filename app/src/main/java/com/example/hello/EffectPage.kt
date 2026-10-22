package com.example.hello

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.ui.Alignment
import com.example.hello.ui.theme.colors

@Composable
fun EffectPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier) {

        Text(
            text = "Effect Page",
            color = colors.primary,
            style = titleXLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }


}