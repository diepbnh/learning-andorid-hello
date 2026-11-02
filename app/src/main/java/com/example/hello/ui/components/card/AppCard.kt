package com.example.hello.ui.components.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.hello.ui.theme.colors
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import com.example.hello.ui.theme.boxShadow
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    hasShadow: Boolean = false,//true có bóng
    hasBorder: Boolean = false,
    //mãu nền, màu viền, màu chữ
    backgroundColor: Color = colors.backgroundCard,//nền card
    textColor: Color = colors.text,//màu text trong card
    borderColor: Color = colors.primary,//màu viền card
    shadowX: Dp = 0.dp,
    shadowY: Dp =8.dp,
    shadowBlur: Dp = 8.dp,
    shadowSpread: Dp = (-2).dp,
    shadowColor: Color = colors.black.copy(alpha = 0.1f),//màu bóng card
    //kich thuoc card
    borderWidth: Dp = 1.dp,
    cornerRadius: Dp = 16.dp,
    contentPadding: Dp = 16.dp,//padding trong card
    content: @Composable ColumnScope.() -> Unit

) {
    val shape = RoundedCornerShape(cornerRadius)
    val shadowModifier = if (hasShadow) {
        Modifier.boxShadow(
            color = shadowColor,
            x = shadowX,
            y = shadowY,
            blur = shadowBlur,
            spread = shadowSpread,
            shape = shape //bóng bo góc
        )
    } else {
        Modifier
    }

    val border = if (hasBorder)
        BorderStroke(borderWidth, borderColor)
    else null
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(shadowModifier),//gắn bóng vào card
        shape = shape,
        border = border,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )

    )
    {
        Column(
            modifier = Modifier.padding(contentPadding)
        )
        {
            content()
        }
    }
}