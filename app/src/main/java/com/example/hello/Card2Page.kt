package com.example.hello

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.runtime.remember
import com.example.hello.ui.components.card.AppCard
import androidx.compose.ui.unit.dp

@Composable
fun Card2Page(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier, scrollable = true) {

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
                text = "Card 2 Page",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        AppCard() {
            Text(
                text = "Card 01 ",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        AppCard(hasShadow = true) {
            Text(
                text = "Card có shadow ",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        AppCard(hasBorder = true) {
            Text(
                text = "Card có border ",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        AppCard(hasShadow = true, hasBorder = true) {
            Text(
                text = "Card có shadow và border ",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        AppCard(
            hasShadow = true,
            shadowColor = colors.danger.copy(alpha = 0.3f)
        ) {
            Text(
                text = "Card có shadow  ",
            )
            Text(
                text = "Card có shadow  ",
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        AppCard(
            backgroundColor = colors.primary,
            textColor = colors.white,
            hasBorder = true,
            borderColor = colors.danger,
            borderWidth = 3.dp
        ) {
            Text(
                text = "Card custom background, text color, border ",
            )
        }
    }
}