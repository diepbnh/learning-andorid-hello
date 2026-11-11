package com.example.hello.ui.components.animation

import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hello.ui.components.button.AppButton
import androidx.compose.animation.fadeIn
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset

@Composable
fun AppToggleBox(
    hideText: String, //text when shown / active
    showText: String,//text when hidden / inactive
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit //inner content
) {
    val isVisible = remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        AppButton(
            text = if (isVisible.value) hideText else showText,
            onClick = { isVisible.value = !isVisible.value },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(
            visible = isVisible.value,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
            modifier = Modifier
                .fillMaxWidth()
                .extendHorizontally(8.dp)

        ) {
            Column(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 10.dp)
            ) {
                content()
            }

        }
    }
}
//shared helper for when box shadow gets clipped
//Widen the element by "extra" on both sides without pushing other elements
 fun Modifier.extendHorizontally(extra: Dp): Modifier = this.layout { measurable, constraints ->
    val extraPx = extra.roundToPx()
    // measure the element 2 * extra wider
    val placeable = measurable.measure(constraints.offset(horizontal = extraPx * 2))
    // but report the original width to the parent
    layout((placeable.width - extraPx * 2).coerceAtLeast(0), placeable.height) {
        placeable.place(-extraPx, 0) // shift left by extra to center it
    }
}
