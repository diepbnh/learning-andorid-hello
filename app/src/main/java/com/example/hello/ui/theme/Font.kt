package com.example.hello.ui.theme


import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.hello.R //import R của dự án để gọi tài nguyên res/font


// Tạo FontFamily liên kết các file trong res/font
val MontserratFontFamily = FontFamily(
    //font regular
    Font(
        resId = R.font.montserrat_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.montserrat_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.montserrat_semibold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.montserrat_bold,
        weight = FontWeight.Bold,

    ),
    Font(
        resId = R.font.montserrat_black,
        weight = FontWeight.Black,
        style = FontStyle.Normal
    ),

)