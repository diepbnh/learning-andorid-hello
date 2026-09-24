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
import androidx.compose.material3.Scaffold
import com.example.hello.ui.components.textfield.AppTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.button.AppButtonSize

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

        ){
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Template Page",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
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
