package com.example.hello.ui.components.dialog


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.hello.ui.theme.colors
import  androidx.compose.foundation.layout.systemBarsPadding

@Composable
fun AppDialog(
    onDismissRequest: () -> Unit,
    backgroundDialog: Color = colors.backgroundDialog, // background color
    cornerRadius: Dp = 24.dp,
    durationMillis: Int = 400,
    content: @Composable ColumnScope.(close: () -> Unit) -> Unit
) {
    val visibleState = remember { MutableTransitionState(false).apply { targetState = true } }
    val close = { visibleState.targetState = false } //call to start fade out
    LaunchedEffect(visibleState.isIdle , visibleState.currentState) {
        if (visibleState.isIdle && !visibleState.currentState) onDismissRequest()

    }
    Dialog(
        onDismissRequest = close, //close dialog on outside click
        properties = DialogProperties(
            usePlatformDefaultWidth = false, //no default dialog width
            decorFitsSystemWindows = false // window draws under status and nav bars
        )
    ) {
        val  view = LocalView.current //View hosting Compose
        SideEffect {
            val window=(view.parent as? DialogWindowProvider)?.window
            window?.setDimAmount(0f) //disable Android dialog dim, styled per Figma
            window?.setWindowAnimations(0) // disable Android slide animation
        }
        //dialog fade in/out animation
        AnimatedVisibility(
            visibleState=visibleState,
            enter = fadeIn(tween(durationMillis)),
            exit = fadeOut(tween(durationMillis))
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize() // dialog width and height
                   .background(backgroundDialog) // dialog dim overlay
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ){close()}
                    .systemBarsPadding() // padding keeps dialog off the status bar
            ) {
                Column( //container wrapping inner text
                    modifier = Modifier
                        .padding(32.dp) // outer margin narrows the Column width
                        .fillMaxWidth()
                        .background(colors.backgroundCard, RoundedCornerShape( cornerRadius))
                        .clickable(interactionSource = null,indication = null) {}//block clicks inside
                        .verticalScroll(rememberScrollState())// scroll when content is long
                        .padding(24.dp) // inner text padding
                ) {
                    content(close) // show passed-in content
                }
            }
        }

    }
}