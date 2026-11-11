package com.example.hello.ui.components.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.hello.ui.theme.colors

@Composable
fun AppDialogBottom(
    onDismissRequest: () -> Unit,
    backgroundDialog: Color = colors.backgroundDialog, // dim overlay color, from theme
    cornerRadius: Dp = 24.dp, // round the 2 top corners
    durationMillis: Int = 300, // slide + fade duration
    content: @Composable ColumnScope.(close: () -> Unit) -> Unit
) {
    val visibleState = remember { MutableTransitionState(false).apply { targetState = true } }
    val close = { visibleState.targetState = false } // call to start sliding down
    LaunchedEffect(visibleState.isIdle, visibleState.currentState) {
        // fully dismiss after sliding down
        if (visibleState.isIdle && !visibleState.currentState) onDismissRequest()
    }
    Dialog(
        onDismissRequest = close, // Back pressed: start sliding down
        properties = DialogProperties(
            usePlatformDefaultWidth = false, // remove width limit, overlay covers full screen
            decorFitsSystemWindows = false // window draws under status and nav bars
        )
    ) {
        val view = LocalView.current
        SideEffect {
            val window = (view.parent as? DialogWindowProvider)?.window
            window?.setDimAmount(0f) // disable Android dim background
            window?.setWindowAnimations(0) // disable Android slide animation
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(tween(durationMillis)), // overlay: fade
            exit = fadeOut(tween(durationMillis))
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter, // place box at bottom
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundDialog) // dialog dim overlay
                    .clickable(interactionSource = null, indication = null) { close() }
                    .statusBarsPadding() // tall box stays below status bar
            ) {
                Column(
                    modifier = Modifier
                        .animateEnterExit( // box: slide up from bottom, slide down on close
                            enter = slideInVertically(tween(durationMillis)) { it },
                            exit = slideOutVertically(tween(durationMillis)) { it }
                        )
                        .fillMaxWidth()
                        .background(
                            colors.backgroundCard,
                            RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius)
                        )
                        .clickable(interactionSource = null, indication = null) {} // block clicks inside
                        .navigationBarsPadding() // leave room for bottom nav bar
                        .verticalScroll(rememberScrollState()) // scroll when content is long
                        .padding(24.dp) // inner padding
                ) {
                    // small drag handle at top of box
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .offset(y=(-10).dp)
                            .size(width = 40.dp, height = 4.dp)
                            .background(colors.light, RoundedCornerShape(2.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    content(close) // show passed-in content
                }
            }
        }
    }
}
