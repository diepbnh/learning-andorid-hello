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
    durationMillis: Int = 200,//run duration
    delayMillis: Int = 0,//delay before start
    playKey: Int = 0,// replay counter
    content: @Composable () -> Unit

) {
    key(playKey) {
        val isVisible = remember { mutableStateOf(false) }

        //run once when the page opens
        LaunchedEffect(Unit) {
            isVisible.value = true
        }

        AnimatedVisibility(
            visible = isVisible.value,
            modifier = modifier,
            enter = fadeIn(tween(durationMillis, delayMillis)) +
                    slideInVertically(tween(durationMillis, delayMillis))
                    {
                        fullHeight -> fullHeight// slide from below, translateY 100%
                    }

        ) {
            content()
        }
    }
}
