package com.example.hello.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ============================================================
// 1. Declare text styles H1 -> H6 directly as TextStyle
//    private, only used to build Typography below
//    Do not call directly from outside this file.
// ============================================================

private val titleXLargeStyle = TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.SemiBold,
    fontSize=24.sp,
    lineHeight=32.sp
)
private val titleLargeStyle= TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.SemiBold,
    fontSize=22.sp,
    lineHeight=30.sp
)
private val titleMediumStyle = TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.SemiBold,
    fontSize=20.sp,
    lineHeight=28.sp
)
private val titleSmallStyle = TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.SemiBold,
    fontSize=18.sp,
    lineHeight=25.sp
)

//for normal body text 16 sp
private val bodyTextStyle= TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.Normal,
    fontSize=16.sp,
    lineHeight=24.sp
)
// ============================================================
// 2. Plug into Material3 standard Typography
// (so Android uses it for default UI)
// ============================================================
// Material3 default Typography(), used as base for original size/line-height
private val defaultTypography = Typography()

val appTypography = Typography(
    headlineSmall = titleXLargeStyle,// 24 sp
    titleLarge = titleLargeStyle,// 22 sp
    titleMedium = titleMediumStyle,// 20 sp
    titleSmall = titleSmallStyle,//18 sp
    bodyLarge = bodyTextStyle, //default for Text/TextField without a style
    bodyMedium = bodyTextStyle,

)
// ============================================================
// 3. EXTENSION PROPERTIES — THE ONLY PUBLIC API to call from UI
//    Short (h1, h2...) but still read from MaterialTheme -> follows theme,
//    auto-updates when switching light/dark later.
// ============================================================
val titleXLarge:TextStyle @Composable get() = MaterialTheme.typography.headlineSmall
val titleLarge:TextStyle @Composable get() = MaterialTheme.typography.titleLarge
val titleMedium:TextStyle @Composable get() = MaterialTheme.typography.titleMedium
val titleSmall:TextStyle @Composable get() = MaterialTheme.typography.titleSmall
val bodyMedium: TextStyle @Composable get()= MaterialTheme.typography.bodyMedium
