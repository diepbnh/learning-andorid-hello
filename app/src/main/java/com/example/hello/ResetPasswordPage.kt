package com.example.hello

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
import androidx.compose.material3.TextField
import com.example.hello.ui.theme.*
import androidx.compose.foundation.layout.fillMaxWidth
import com.example.hello.ui.components.textfield.AppTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.hello.ui.components.button.AppButton


@Composable
fun ResetPasswordPage(modifier: Modifier = Modifier, navController: NavController) {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "Reset Password",
            color = colors.primary,
            style = titleXLarge,
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter old password") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(25.dp))
        AppTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(25.dp))
        AppButton(
            text="Save",
            onClick = {},
            backgroundColor=colors.danger
        )


    }

}