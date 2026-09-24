package com.example.hello

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import  androidx.compose.foundation.clickable
import androidx.compose.ui.text.style.TextDecoration
import com.example.hello.ui.components.textfield.AppFormField

@Composable
fun SignUpPage(modifier: Modifier = Modifier, navController: NavController) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    Scaffold(modifier,containerColor = Color.Transparent) {
        innerPadding ->
        Column(
            modifier=Modifier.padding(innerPadding)
                .fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(65.dp))
            Text(
                text = "Sign Up",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(25.dp))
            //sử dụng AppFormField để hiển thị textfield
            AppFormField(
                label = "User Name:",
                value = username.value,
                onValueChange = { username.value = it },
                placeholder = "Enter Username.....",

                )
            AppFormField(
                label = "Password:",
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = "Enter password.....",
                isPassword = true,
            )

            AppFormField(
                label = "Confirm Password:",
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
                placeholder = "Enter password.....",
                isPassword = true,
            )

            AppButton(
                text = "Sign up",
                onClick = {},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier= Modifier.height(10.dp))
            Text(
                text = "Back",
                fontWeight = FontWeight.Medium,
                color=colors.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navController.popBackStack()//hàm back trở về màn hình trước đó
                    }
                ,
            )
        }
    }

}