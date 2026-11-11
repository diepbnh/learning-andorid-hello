package com.example.hello

import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import com.example.hello.ui.theme.*
import androidx.compose.runtime.remember
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.button.AppButtonSize
import com.example.hello.ui.components.textfield.AppFormField
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar
import kotlinx.coroutines.launch

@Composable
fun TemplatePage(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed) //menu open/close
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "template"//current page
    ) {
        AppPage(
            modifier = modifier, scrollable = true, topBar = {
                AppTopBar(title = "Template", navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(
                            imageVector = Icons.Default.Menu, contentDescription = "Menu"
                        )
                    }
                }, actions = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.Default.Home, contentDescription = "Home"
                        )
                    }
                })
            }) {
            Column{

                Text(
                    text = "Back",
                    style = titleMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(colors.primary)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null // remove ripple effect on press
                        ) {
                            navController.popBackStack()//go back to the previous screen
                        }
                        .padding(25.dp, 10.dp))
                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                //row
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Profile",
                        style = titleMedium,
                        color = colors.primary,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier

                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null // remove ripple effect on press
                            ) {
                                navController.navigate("profile")//go back to the previous screen
                            }

                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Table",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("table")
                            }

                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Card",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("card")
                            })
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Login",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("login")
                            })
                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "ToggleButton",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("toggle_button")
                            })
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Dialog",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("dialog")
                            })
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Card 2",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("card2")
                            })
                }
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Checkbox and Switch",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("checkbox")
                            })
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Radio",
                        textDecoration = TextDecoration.Underline,
                        style = titleMedium,
                        color = colors.primary,
                        modifier = Modifier.clickable {
                                navController.navigate("radio")
                            })
                }





                Spacer(
                    modifier = Modifier.height(25.dp)
                )


                //component input
                AppFormField(
                    label = "Label input",
                    value = "",
                    onValueChange = { },
                    placeholder = "Enter input.....",
                    isPassword = false,
                    isError = true,
                    errorMessage = "Show the input error here"
                )
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                AppButton(
                    text = "Button Small",
                    onClick = {},
                    backgroundColor = colors.primary,
                    size = AppButtonSize.Small
                )
                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                AppButton(
                    text = "Button Medium",
                    onClick = {},
                    backgroundColor = colors.danger,
                    size = AppButtonSize.Medium
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )
                AppButton(
                    text = "Dark Mode",
                    onClick = {},
                    backgroundColor = colors.secondary,
                    size = AppButtonSize.Large
                )
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                // Light/Dark mode toggle buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    AppButton(
                        text = "Light Mode",
                        onClick = { ThemeManager.setDarkMode(false) },
                        modifier = Modifier.weight(1f),
                        backgroundColor = colors.danger
                    )
                    AppButton(
                        text = "Dark Mode",
                        onClick = { ThemeManager.setDarkMode(true) },
                        modifier = Modifier.weight(1f),
                        backgroundColor = colors.primary,

                        )
                }

            }
        }
    }

}
