package com.example.hello.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

object ThemeManager {
    private val _isDarkMode = mutableStateOf(false)//mặc dịnh light
    val isDarkMode: State<Boolean> get() = _isDarkMode
    fun setDarkMode(enabled: Boolean) {
        _isDarkMode.value = enabled
    }
    fun toggle() {
        _isDarkMode.value = !_isDarkMode.value
    }
}