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
    backgroundDialog: Color = colors.backgroundDialog, // màu nền mờ, lấy từ theme
    cornerRadius: Dp = 24.dp, // bo 2 góc trên
    durationMillis: Int = 300, // thời gian trượt + fade
    content: @Composable ColumnScope.(close: () -> Unit) -> Unit
) {
    val visibleState = remember { MutableTransitionState(false).apply { targetState = true } }
    val close = { visibleState.targetState = false } // gọi để bắt đầu trượt xuống
    LaunchedEffect(visibleState.isIdle, visibleState.currentState) {
        // trượt xuống xong mới tắt hẳn
        if (visibleState.isIdle && !visibleState.currentState) onDismissRequest()
    }
    Dialog(
        onDismissRequest = close, // bấm Back: bắt đầu trượt xuống
        properties = DialogProperties(
            usePlatformDefaultWidth = false, // bỏ giới hạn chiều rộng, cho nền phủ hết màn hình
            decorFitsSystemWindows = false // cửa sổ vẽ tràn thanh trạng thái và điều hướng
        )
    ) {
        val view = LocalView.current
        SideEffect {
            val window = (view.parent as? DialogWindowProvider)?.window
            window?.setDimAmount(0f) // tắt nền đen của android
            window?.setWindowAnimations(0) // tắt hiệu ứng trượt của android
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(tween(durationMillis)), // nền mờ: fade
            exit = fadeOut(tween(durationMillis))
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter, // đặt hộp ở đáy
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundDialog) // nền mờ của dialog
                    .clickable(interactionSource = null, indication = null) { close() }
                    .statusBarsPadding() // hộp dài không chui dưới thanh trạng thái
            ) {
                Column(
                    modifier = Modifier
                        .animateEnterExit( // hộp: trượt từ đáy lên, trượt xuống khi đóng
                            enter = slideInVertically(tween(durationMillis)) { it },
                            exit = slideOutVertically(tween(durationMillis)) { it }
                        )
                        .fillMaxWidth()
                        .background(
                            colors.backgroundCard,
                            RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius)
                        )
                        .clickable(interactionSource = null, indication = null) {} // chặn click bên trong
                        .navigationBarsPadding() // chừa chỗ cho thanh điều hướng ở đáy
                        .verticalScroll(rememberScrollState()) // scroll nội dung khi dài
                        .padding(24.dp) // padding bên trong
                ) {
                    // thanh kéo nhỏ ở đầu hộp
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .offset(y=(-10).dp)
                            .size(width = 40.dp, height = 4.dp)
                            .background(colors.light, RoundedCornerShape(2.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    content(close) // hiện thị nội dung truyền vào
                }
            }
        }
    }
}
