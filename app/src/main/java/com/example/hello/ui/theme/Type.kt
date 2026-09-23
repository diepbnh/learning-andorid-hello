package com.example.hello.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ============================================================
// 1. Khai báo trực tiếp các kiểu chữ H1 -> H6 dạng TextStyle
//    private, chỉ dùng để build Typography bên dưới
//    Không được gọi trực tiếp từ bên ngoài file này.
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

//dùng cho font chữ text bình thường 16 sp
private val bodyTextStyle= TextStyle(
    fontFamily=MontserratFontFamily,
    fontWeight=FontWeight.Normal,
    fontSize=16.sp,
    lineHeight=20.sp
)
// ============================================================
// 2. Tích hợp vào Typography chuẩn của Material3
// (để Android dùng cho các UI mặc định)
// ============================================================
// Typography() mặc định của Material3, dùng làm nền để lấy size/line-height gốc
private val defaultTypography = Typography()

val appTypography = Typography(
    headlineSmall = titleXLargeStyle,// 24 sp
    titleLarge = titleLargeStyle,// 22 sp
    titleMedium = titleMediumStyle,// 20 sp
    titleSmall = titleSmallStyle,//18 sp
    bodyLarge = bodyTextStyle, //mặc định cho Text/TextField không khai báo style
    bodyMedium = bodyTextStyle,

)
// ============================================================
// 3. EXTENSION PROPERTIES — API CÔNG KHAI DUY NHẤT để gọi từ UI
//    Gọn (h1, h2...) nhưng vẫn lấy từ MaterialTheme -> theo theme,
//    tự đổi khi chuyển light/dark sau này.
// ============================================================
val titleXLarge:TextStyle @Composable get() = MaterialTheme.typography.headlineSmall
val titleLarge:TextStyle @Composable get() = MaterialTheme.typography.titleLarge
val titleMedium:TextStyle @Composable get() = MaterialTheme.typography.titleMedium
val titleSmall:TextStyle @Composable get() = MaterialTheme.typography.titleSmall
val bodyMedium: TextStyle @Composable get()= MaterialTheme.typography.bodyMedium
