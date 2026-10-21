package com.example.hello.ui.components.animation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hello.R

@Composable
fun AppGrassButterfly(
    modifier: Modifier = Modifier,
    height: Dp = 160.dp, // box wrapper
    grassHeight: Dp = 80.dp,
    butterflySize: Dp = 40.dp,
    @DrawableRes grassRes: Int = R.drawable.hinhnen,
    @DrawableRes butterflyRes: Int = R.drawable.con_buom
) {
    val infiniteTransition = rememberInfiniteTransition(label = "butterfly_flight")

    // Quỹ đạo bay ngang: từ phải (130f) sang trái (-130f) trong 3s, rồi quay lại từ trái sang phải trong 3s
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 130f,
        targetValue = 130f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 6000 // Tổng thời gian 1 vòng lặp là 6 giây
                130f at 0 // Giây 0: Bắt đầu ở bên phải (+130dp)
                (-130f) at 3000  // Giây thứ 3: Bay sang bên trái (-130dp)
                130f at 6000  // Giây thứ 6: Quay về bên phải (+130dp)
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "butterfly_offset_x"
    )

    // Hiệu ứng quay đầu (lật hướng bướm khi đổi chiều bay)
    val scaleX by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 6000
                1f at 0
                1f at 2999
                (-1f) at 3000  // Đúng giây thứ 3 (khi đổi chiều bay), lật ngang ảnh
                (-1f) at 5999
                1f at 6000  // Quay về hướng ban đầu
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "butterfly_scale_x"
    )

    // Hiệu ứng vỗ cánh (co giãn theo chiều dọc scaleY với tốc độ nhanh)
    val scaleY by infiniteTransition.animateFloat(
        initialValue = 0.75f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 200 // Vòng đời vỗ cánh rất nhanh: chỉ 0.2 giây
                0.75f at 0
                1.05f at 100
                0.75f at 200
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "butterfly_wing_flap"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clipToBounds()// Cắt bỏ các phần hình ảnh thừa tràn ra ngoài khung

    ) {
        Image(
            painter = painterResource(grassRes),
            contentDescription = "Hinh bãi cỏ",
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(grassHeight)
        )

        // Con bướm bay qua lại, tự động quay đầu và vỗ cánh
        Image(
            painter = painterResource(butterflyRes),
            contentDescription = "Con bướm",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = offsetX.dp)
                .height(butterflySize)
                .graphicsLayer(
                    scaleX = scaleX,
                    scaleY = scaleY
                )
        )
    }
}
