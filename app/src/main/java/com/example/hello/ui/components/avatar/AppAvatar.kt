package com.example.hello.ui.components.avatar

import androidx.compose.runtime.Composable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.hello.ui.theme.colors
import androidx.compose.ui.graphics.Color

@Composable
fun AppAvatar(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp, //mặc định 80
    shape: Shape = CircleShape,//mặc định bo tròn
    borderWidth: Dp = 0.dp, //mặc định
    borderColor: Color = colors.white,
    contentDescription: String? = "Avatar"
) {
    Image(
        painter = painterResource(imageRes),//đường dẫn ảnh
        contentDescription = contentDescription,//mô tả ảnh
        modifier = modifier
            .size(size)
            .clip(shape)//cắt ảnh
            .then(
                if (borderWidth > 0.dp)
                    Modifier.border(borderWidth,borderColor,shape)
                else
                    Modifier
            ),

        contentScale = ContentScale.Crop
    )

}