package com.example.hello.ui.components.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.hello.ui.components.button.AppButton
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun AppFadeBox(
    showText: String,
    hideText: String,
    modifier: Modifier = Modifier,
    initialVisible: Boolean = true,//lúc mới mở true= hiên,
    durationMillis: Int = 400,//thời gian hiện
    content: @Composable () -> Unit

) {
    val isVisible = remember { mutableStateOf(initialVisible) }

    val contentAlpha = animateFloatAsState(
        targetValue = if (isVisible.value) 1f else 0f,
        animationSpec = tween(durationMillis = durationMillis),
        label = "fade_box_content_alpha"
    )
    Column(
        modifier = modifier
    ) {
        AppButton(
            text = if (isVisible.value) hideText else showText,
            onClick = { isVisible.value = !isVisible.value },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .extendHorizontally(8.dp) //nới khung rộng ra 2 bên
                .alpha(contentAlpha.value)//giống CSS opacity
                .padding(start = 8.dp, end = 8.dp, bottom = 12.dp)

        ) {
            content()
        }
    }

}