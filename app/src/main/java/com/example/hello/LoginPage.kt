package com.example.hello
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.theme.*

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController) {
    // 1. Declare state to store input data
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginError= remember { mutableStateOf("") }
    // 2. Screen layout structure
    Scaffold(modifier, containerColor = Color.Transparent) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize() // Fill all remaining space
                .padding(innerPadding)
                .padding(32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            //spacing
            Spacer(modifier = Modifier.height(65.dp))
            Text(
                text = "Login Page",
               // fontSize = 30.sp,
                color = colors.primary,
                //fontWeight = FontWeight.Bold,
                style = titleXLarge,
            )
            //spacing
            Spacer(modifier = Modifier.height(25.dp))
            // Username input
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it
                                loginError.value=""
                                },

                isError = loginError.value == "Username is required", // only Username field gets red border on error
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Enter username")
                },

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.white,//bg textfield
                    unfocusedContainerColor = colors.white,//bg
                    focusedBorderColor = colors.primary,//focused border color
                    unfocusedBorderColor = colors.light,//unfocused border color
                    errorBorderColor = colors.danger,//error border color
                )
            )
            //spacing
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            // Password input
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it
                    loginError.value=""},

                isError = loginError.value == "Password is required",  // only Password field gets red border on error
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Enter Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colors.white,
                    unfocusedContainerColor = colors.white,
                    focusedBorderColor = colors.primary,
                    unfocusedBorderColor = colors.light,
                    errorBorderColor = colors.danger,
                )
            )
            //spacing
            Spacer(
                modifier = Modifier.height(25.dp)
            )

            //error message label before Login button
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
                        navController.navigate("profile")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = colors.primary,
            )
            //spacing
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
            //spacing
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


        }
    }
}
