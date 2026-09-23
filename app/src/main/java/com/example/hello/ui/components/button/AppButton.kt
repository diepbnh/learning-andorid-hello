package com.example.hello.ui.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp//khích thước button, khoảng cách
import androidx.compose.ui.unit.sp//font size
import com.example.hello.ui.theme.colors

@Composable
fun AppButton(
    modifier: Modifier= Modifier,
    text:String,
    onClick:()-> Unit,
    enabled:Boolean =true,
    backgroundColor: Color = colors.primary,//màu mặc định
    size: AppButtonSize = AppButtonSize.Medium// size mặc định
){
    Button(
        onClick = onClick,
        modifier = modifier.height(size.height).widthIn(min = 200.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,contentColor=colors.white)
    )
    {
        Text(
            text=text,
            fontSize = size.fontSize
        )
    }
}