package com.example.hello.ui.theme


import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.hello.R //import project R to access res/font resources


// Create FontFamily linking files in res/font
val MontserratFontFamily = FontFamily(
    //font regular
    Font(
        resId = R.font.montserrat_regular,
        weight = FontWeight.Normal,

    ),
    Font(
        resId = R.font.montserrat_medium,
        weight = FontWeight.Medium,

    ),
    Font(
        resId = R.font.montserrat_semibold,
        weight = FontWeight.SemiBold,

    ),
    Font(
        resId = R.font.montserrat_bold,
        weight = FontWeight.Bold,

    ),
    Font(
        resId = R.font.montserrat_black,
        weight = FontWeight.Black,

    ),

)