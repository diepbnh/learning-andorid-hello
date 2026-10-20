package com.example.hello.ui.components.avatar

import androidx.compose.runtime.Composable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppAvatar(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp, //mặc định 80
    shape: Shape = CircleShape,//mặc định bo tròn
    contentDescription: String? = "Avatar"
) {

}