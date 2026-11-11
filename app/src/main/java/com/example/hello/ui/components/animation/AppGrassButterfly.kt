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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.ui.unit.IntOffset

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

    // Horizontal path: right (130f) to left (-130f) in 3s, then back left to right in 3s
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 130f,
        targetValue = 130f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 6000 // One loop takes 6 seconds
                130f at 0 // Second 0: start on the right (+130dp)
                (-130f) at 3000  // Second 3: fly to the left (-130dp)
                130f at 6000  // Second 6: back to the right (+130dp)
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "butterfly_offset_x"
    )

    // Turn-around effect (flip butterfly when direction changes)
    val scaleX by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 6000
                1f at 0
                1f at 2999
                (-1f) at 3000  // At second 3 (direction change), flip image horizontally
                (-1f) at 5999
                1f at 6000  // Back to original direction
            },
            repeatMode = RepeatMode.Restart
        ),
        label = "butterfly_scale_x"
    )

    // Wing-flap effect (fast vertical scaleY stretch)
    val scaleY by infiniteTransition.animateFloat(
        initialValue = 0.75f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 200 // Very fast flap cycle: only 0.2 seconds
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
            .requiredHeight(height) //min height
            .clipToBounds()// Clip image parts overflowing the frame

    ) {
        Image(
            painter = painterResource(grassRes),
            contentDescription = "Grass field image",
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(grassHeight)
        )

        // Butterfly flies back and forth, turning and flapping
        Image(
            painter = painterResource(butterflyRes),
            contentDescription = "Butterfly",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.Center)
                .offset{IntOffset(x = offsetX.dp.roundToPx(), y = 0)}
                .height(butterflySize)
                .graphicsLayer(
                    scaleX = scaleX,
                    scaleY = scaleY
                )
        )
    }
}
