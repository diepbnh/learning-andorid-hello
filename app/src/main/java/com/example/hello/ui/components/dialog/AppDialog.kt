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
    backgroundDialog: Color = colors.backgroundDialog, // màu nền
    cornerRadius: Dp = 24.dp,
    durationMillis: Int = 400,
    content: @Composable ColumnScope.(close: () -> Unit) -> Unit
) {
    val visibleState = remember { MutableTransitionState(false).apply { targetState = true } }
    val close = { visibleState.targetState = false } //gọi để bắt đầu fade out
    LaunchedEffect(visibleState.isIdle , visibleState.currentState) {
        if (visibleState.isIdle && !visibleState.currentState) onDismissRequest()

    }
    Dialog(
        onDismissRequest = close, //close dialog khi click ra ngoài
        properties = DialogProperties(
            usePlatformDefaultWidth = false, //dialog không có chiều rộng
            decorFitsSystemWindows = false // cửa sổ vẽ tràn thanh trạng thái và điều hướng
        )
    ) {
        val  view = LocalView.current //View đang chứa Compose
        SideEffect {
            val window=(view.parent as? DialogWindowProvider)?.window
            window?.setDimAmount(0f) //tắt nền đèn dialog của android do set theo figma
            window?.setWindowAnimations(0) // tắt hiệu ứng trượt cua android
        }
        //hiệu ứng fade in fade out dialog
        AnimatedVisibility(
            visibleState=visibleState,
            enter = fadeIn(tween(durationMillis)),
            exit = fadeOut(tween(durationMillis))
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize() // chiều cao và rộng dialog
                   .background(backgroundDialog) // nền mờ của dialog
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ){close()}
                    .systemBarsPadding() // padding giảm chiều cao dialog không đụng thanh trạng thái
            ) {
                Column( //container bao text bên trong
                    modifier = Modifier
                        .padding(32.dp) // margin tu bên ngoài làm thu nhỏ width của Column
                        .fillMaxWidth()
                        .background(colors.backgroundCard, RoundedCornerShape( cornerRadius))
                        .clickable(interactionSource = null,indication = null) {}//chặn click bên trong
                        .verticalScroll(rememberScrollState())// scroll nội dung khi dài
                        .padding(24.dp) // padding bên trong text
                ) {
                    content(close) // hiện thị nội dung truyền vào
                }
            }
        }

    }
}