package com.example.hello

import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.button.AppButtonSize
import com.example.hello.ui.components.textfield.AppFormField
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width

@Composable
fun TemplatePage(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(modifier, containerColor = Color.Transparent) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize() // Chiếm toàn bộ diện tích còn lại
                .padding(innerPadding)
                .padding(32.dp),
            verticalArrangement = Arrangement.Top,
            // horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Template Page",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Back",
                style = titleMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(colors.primary)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null // bỏ hiệu ứng ripple khi nhấn
                    ) {
                        navController.popBackStack()//hàm back trở về màn hình trước đó
                    }
                    .padding(25.dp, 10.dp)
            )
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
                            indication = null // bỏ hiệu ứng ripple khi nhấn
                        ) {
                            navController.navigate("profile")//hàm back trở về màn hình trước đó
                        }

                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Table",
                    textDecoration = TextDecoration.Underline,
                    style = titleMedium,
                    color = colors.primary,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("table")
                        }

                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Card",
                    textDecoration = TextDecoration.Underline,
                    style = titleMedium,
                    color = colors.primary,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("card")
                        }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Login",
                    textDecoration = TextDecoration.Underline,
                    style = titleMedium,
                    color = colors.primary,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("login")
                        }
                )
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
                    modifier = Modifier
                        .clickable {
                            navController.navigate("toggle_button")
                        }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Dialog",
                    textDecoration = TextDecoration.Underline,
                    style = titleMedium,
                    color = colors.primary,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("dialog")
                        }
                )
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
                errorMessage = "Hiện thị error của input ở đây"
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

        }
    }

}
