package com.example.hello

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.material3.Text
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import com.example.hello.ui.components.card.AppCard
import androidx.compose.ui.unit.dp
import com.example.hello.ui.components.layout.AppTopBar
import androidx.compose.material3.TextButton

@Composable
fun Card2Page(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(
        modifier = modifier,
        scrollable = true,
        topBar = {
            AppTopBar(
                title = "Card",
                navigationIcon = {
                    TextButton(
                        onClick = { navController.navigate("login") },
                    )
                    {
                        Text(
                            text = "Logout",
                            color = colors.white
                        )
                    }
                },
                actions = {
                    TextButton(
                        onClick = { navController.navigate("template") },
                    ) {
                        Text(
                            text = "Template",
                            color = colors.white,
                        )
                    }
                }
            )

        }

    ) {


        AppCard {
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