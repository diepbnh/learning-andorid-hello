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
import androidx.compose.material3.CardElevation
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import com.example.hello.ui.theme.colors
import androidx.compose.ui.graphics.Color

@Composable
fun AppAvatar(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp, //default 80
    shape: Shape = CircleShape,//default circle
    borderWidth: Dp = 0.dp, //default
    borderColor: Color = colors.white,
    shadowElevation: Dp=0.dp,//default no shadow
    contentDescription: String? = "Avatar"
) {
    Image(
        painter = painterResource(imageRes),//image resource
        contentDescription = contentDescription,//image description
        modifier = modifier
            .size(size)
            .shadow(shadowElevation,shape) // shadow first
            .clip(shape)//clip image
            .then(
                if (borderWidth > 0.dp)
                    Modifier.border(borderWidth,borderColor,shape)
                else
                    Modifier
            ),

        contentScale = ContentScale.Crop
    )

}