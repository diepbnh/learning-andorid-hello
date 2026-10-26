package com.example.hello.ui.components.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun AppSlideUp(
    modifier: Modifier = Modifier,
    durationMillis: Int = 200,//thời gian chạy
    delayMillis: Int = 0,//thời gian đợi
    playKey: Int = 0,// số lần chạy
    content: @Composable () -> Unit

) {
    key(playKey) {
        val isVisible = remember { mutableStateOf(false) }

        //chay 1 lần khi mở trang
        LaunchedEffect(Unit) {
            isVisible.value = true
        }

        AnimatedVisibility(
            visible = isVisible.value,
            modifier = modifier,
            enter = fadeIn(tween(durationMillis, delayMillis)) +
                    slideInVertically(tween(durationMillis, delayMillis))
                    {
                        fullHeight -> fullHeight// bắt chuyển từ trên xuống dưới tranlateY 100%
                    }

        ) {
            content()
        }
    }
}
