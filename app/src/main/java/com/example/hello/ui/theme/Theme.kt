package com.example.hello.ui.theme


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

    @Composable
    fun HelloTheme(
        content: @Composable () -> Unit
    )
    {
        val darkTheme = ThemeManager.isDarkMode.value //đọc trạng thái đang có
        val appColors = if (darkTheme) DarkAppColors else LightAppColors

        CompositionLocalProvider(LocalAppColors provides appColors) {
            MaterialTheme(
                typography = appTypography
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colors.backgroundBody//màu nền body
                ) {
                    content()
                }
            }
        }
    }