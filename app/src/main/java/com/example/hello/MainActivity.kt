package com.example.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hello.ui.theme.HelloTheme

import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    //dieu hương route
                    composable("login") {
                        LoginPage(modifier = Modifier.fillMaxSize(), navController = navController)
                    }
                    composable("reset_password") {
                        ResetPasswordPage(modifier = Modifier.fillMaxSize(), navController = navController)
                    }
                    composable(route = "sign_up") {
                        SignUpPage(modifier = Modifier.fillMaxSize(), navController = navController)
                    }
                    composable(route = "template") {
                        TemplatePage(modifier = Modifier.fillMaxSize(), navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloTheme {
        Greeting("Hong Diep")
    }
}