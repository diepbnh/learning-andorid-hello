package com.example.hello.ui.components.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.hello.ui.theme.colors
import androidx.compose.ui.graphics.Color
import com.example.hello.ui.components.button.AppButtonSize
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppToggleButton(
    hideText: String, //chữ chưa nhấn
    showText: String,//chữ đã nhan
    modifier: Modifier = Modifier,
    inactiveColor: Color = colors.primary, //màu nút chưa nhấn
    activeColor: Color = colors.danger, //màu nút nhấn
    durationMillis: Int = 200, //thời gian đổi màu
    inactiveRadius: Dp =25.dp,
    activeRadius: Dp=25.dp,
) {

    val isActive = remember { mutableStateOf(false) }
    //durationMillis button
    val buttonColor = animateColorAsState(
        targetValue = if (isActive.value) activeColor else inactiveColor,
        animationSpec = tween(durationMillis = durationMillis),
        label = "toggleButtonColor"
    )
    //bo góc
    val cornerRadius = animateDpAsState(
        targetValue = if (isActive.value) activeRadius else inactiveRadius,
        animationSpec = tween(durationMillis = durationMillis),
        label = "toggleButtonRadius"
    )

    Button(
        onClick = { isActive.value = !isActive.value },
        modifier = modifier.height(AppButtonSize.Medium.height), // giống chiều cao AppButton
        shape = RoundedCornerShape(cornerRadius.value),// truyền radius vào
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor.value,
            contentColor = colors.white //màu chữ
        )

    ) {
        AnimatedContent (
            targetState = isActive.value,
            contentAlignment = Alignment.Center,
           transitionSpec = {
               fadeIn(animationSpec = tween(durationMillis / 2, delayMillis
               = durationMillis / 2)) togetherWith
                       // chữ cũ: mờ hết trong nửa đầu
                       fadeOut(animationSpec = tween(durationMillis / 2)) using
                       SizeTransform(clip = false) { _, _ ->
                           tween(durationMillis)
                       }

    },
            label = "toggleButtonText"

        ) { active ->
            Text(
                text = if(active) showText else hideText,
                fontSize = AppButtonSize.Medium.fontSize // cỡ chữ giống AppButton
            )

        }
    }

}