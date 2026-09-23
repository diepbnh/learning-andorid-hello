package com.example.hello.ui.components.button
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
enum class AppButtonSize (
    val height:Dp,
    val fontSize: TextUnit
){
    Small(
        height = 30.dp,
        fontSize = 12.sp
    ),
    Medium(
        height = 50.dp,
        fontSize = 16.sp
    ),
    Large(
        height = 70.dp,
        fontSize = 30.sp
    )
}