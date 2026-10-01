package com.example.hello

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.theme.colors
import androidx.compose.ui.unit.sp

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController) {
    // 1. Khai báo trạng thái để lưu trữ dữ liệu nhập vào
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginError= remember { mutableStateOf("") }
    // 2. Cấu trúc khung màn hình
    Scaffold(modifier, containerColor = Color.Transparent) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize() // Chiếm toàn bộ diện tích còn lại
                .padding(innerPadding)
                .padding(32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            //khoản cach
            Spacer(modifier = Modifier.height(65.dp))
            Text(
                text = "Login Page",
               // fontSize = 30.sp,
                color = colors.primary,
                //fontWeight = FontWeight.Bold,
                style = titleXLarge,
            )
            //khoản cach
            Spacer(modifier = Modifier.height(25.dp))

            // Username input
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it
                                loginError.value=""
                                },

                isError = loginError.value == "Username is required", // chỉ ô Username đỏ viền khi lỗi
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Enter username")
                },

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.white,//bg textfield
                    unfocusedContainerColor = colors.white,//bg
                    focusedBorderColor = colors.primary,//màu viền focus
                    unfocusedBorderColor = colors.light,//màu viền không focus
                    errorBorderColor = colors.danger,//màu viền khi lỗi
                )
            )
            //khoản cách
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            // Password input
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it
                    loginError.value=""},

                isError = loginError.value == "Password is required",  // chỉ ô Password đỏ viền khi lỗi
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Enter Password")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.white,
                    unfocusedContainerColor = colors.white,
                    focusedBorderColor = colors.primary,
                    unfocusedBorderColor = colors.light,
                    errorBorderColor = colors.danger,
                )
            )
            //khoản cach
            Spacer(
                modifier = Modifier.height(25.dp)
            )

            //label thông báo lỗi trươ button Login
            if(loginError.value.isNotEmpty()){
                Text(
                    text=loginError.value,
                    color=colors.danger,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier=Modifier.padding(bottom = 14.dp)
                        .fillMaxWidth()
                )
            }

            // Login button
            AppButton(
                text="Login",
                onClick = {
                    if(username.value.isEmpty()){
                        loginError.value="Username is required"
                    }
                    else if(password.value.isBlank()){
                        loginError.value="Password is required"
                    }
                    else{
                        navController.navigate("template")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = colors.primary,
            )
            //khoản cach
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            //
            //Reset Password
            Text(
                text="Reset Password",
                color = colors.primary,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                modifier=Modifier.clickable {
                    navController.navigate("reset_password")
                }
            )
            //khoản cach
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Text(
                text = "Sign Up",
                textDecoration =TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                modifier= Modifier.clickable{navController.navigate(route = "sign_up")}
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Text(
                text = "Template Page",
                textDecoration =TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                modifier= Modifier.clickable{navController.navigate(route = "template")}
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
