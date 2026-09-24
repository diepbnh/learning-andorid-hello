package com.example.hello

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.fillMaxWidth
import com.example.hello.ui.components.textfield.AppTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import com.example.hello.ui.components.button.AppButton


@Composable
fun ResetPasswordPage(modifier: Modifier = Modifier, navController: NavController) {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
       // horizontalAlignment = Alignment.Start
    )
    {
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "Reset Password",
            color = colors.primary,
            style = titleXLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Old Password:",
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(bottom = 10.dp),
        )

        AppTextField(
            value = oldPassword,
            onValueChange = { oldPassword = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Old Password",
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "New Password:",
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(bottom = 10.dp),

        )
        AppTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = "New Password",
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(25.dp))

        AppButton(
            text="Save",
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text="Login",
            color = colors.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate("login")
                },
            textDecoration = TextDecoration.Underline,
        )

    }

}