package com.example.hello

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.material3.Text
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.hello.ui.components.card.AppCard
import androidx.compose.ui.unit.dp
import com.example.hello.ui.components.layout.AppTopBar
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.hello.ui.components.layout.AppDrawer
import kotlinx.coroutines.launch

@Composable
fun Card2Page(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)//menu đóng hay mở
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "card2"
    ) {
        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Card 2",
                    navigationIcon = {
                        IconButton (onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
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
}