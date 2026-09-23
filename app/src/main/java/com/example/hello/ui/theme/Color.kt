package com.example.hello.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.Composable


// ============================================================
// 1. COLOR SCHEME
// ============================================================
//set for color LIGHT MODE
private object LightMode{
    val primary = Color(0xFF1a75cf)
    val secondary = Color(0xFF4b9cdf)
    val light = Color(0xFFdfe4e8)
    val danger= Color(0xFFec5b5b)
    val text= Color(0xFF2f3134)//màu text
    val backgroundBody= Color(0xFFeff5ff) // màu nền body
    val white= Color(0xFFFFFFFF)

}

//set for color DARK MODE
private object DarkMode{
    val primary = Color(0xFF6b74f5)
    val secondary = Color(0xFF79b8ea)
    val light = Color(0xFF22262c)
    val danger= Color(0xFFf28b8b)
    val text= Color(0xFFffffff)//màu text
    val backgroundBody= Color(0xFF12141A) // màu nền body
    val white= Color(0xFFFFFFFF)

}
// ============================================================
// 2. APP COLORS
// ============================================================
data class AppColors(
    val primary: Color,
    val secondary: Color,
    val light: Color,
    val danger: Color,
    val text: Color,
    val backgroundBody: Color,
    val white: Color,
)
// ============================================================
// 3. LIGHT AND DARK APP COLORs
// ============================================================
val LightAppColors=AppColors(
    primary = LightMode.primary,
    secondary = LightMode.secondary,
    light = LightMode.light,
    danger = LightMode.danger,
    text = LightMode.text,
    backgroundBody = LightMode.backgroundBody,
    white= LightMode.white,
)
val DarkAppColors=AppColors(
    primary = DarkMode.primary,
    secondary = DarkMode.secondary,
    light = DarkMode.light,
    danger = DarkMode.danger,
    text = DarkMode.text,
    backgroundBody = DarkMode.backgroundBody,
    white= DarkMode.white,
)

// ============================================================
// 4. cầu nối giữa Theme.kt và các màn hình UI
// ============================================================
val LocalAppColors = staticCompositionLocalOf {
    LightAppColors
}
// ============================================================
// 5. EXTENSION — chỉ cần 1 dòng duy nhất, thay vì viết riêng từng màu
// qua trang UI chỉ cần gọi nó ra sử dụng: color=colors.primary
// ============================================================
val colors: AppColors @Composable get() = LocalAppColors.current