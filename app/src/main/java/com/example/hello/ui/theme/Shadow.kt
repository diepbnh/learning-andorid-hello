package com.example.hello.ui.theme

import android.graphics.BlurMaskFilter
import android.os.Build
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// ============================================================
// boxShadow — SHARED SHADOW, callable from any page / component
//    Like Figma "Drop shadow" / CSS box-shadow: x y blur spread color
//
//   color  : shadow color (can include opacity: color.copy(alpha = 0.25f))
//   x      : horizontal offset (Figma X)
//   y      : vertical offset   (Figma Y)
//   blur   : blur amount (Figma Blur) — copy the number from Figma
//   spread : expand      (Figma Spread), negative = shrink: (-4).dp
//   shape  : element shape — pass the SAME shape as the Card/Box/...
//
// If Figma has no value for a param, omit it to use the default.
// For multiple shadow layers, chain several .boxShadow(...) calls.
//
// Android 9+      -> draws exactly per the params
// Below Android 9  -> falls back to built-in shadow() (black, approximate)
// ============================================================
fun Modifier.boxShadow(
    color: Color, // shadow color, required (e.g. colors.black.copy(alpha = 0.25f))
    x: Dp = 0.dp, // horizontal offset
    y: Dp = 0.dp, // vertical offset
    blur: Dp = 0.dp,// blur
    spread: Dp = 0.dp, // spread
    shape: Shape = RectangleShape,// component shape
): Modifier {
    // Old devices: GPU cannot blur -> use built-in shadow()
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
        return this.shadow(elevation = y + blur / 2, shape = shape, clip = false)
    }

    // New devices: draw the shadow behind the element ourselves
    // drawWithCache: only rebuild the shadow when the element size changes
    return this.drawWithCache {
        val spreadPx = spread.toPx()

        // shadow shape = element shape + spread
        val shadowSize = Size(
            (size.width + spreadPx * 2).coerceAtLeast(0f),
            (size.height + spreadPx * 2).coerceAtLeast(0f),
        )
        val shadowPath = Path().apply {
            addOutline(shape.createOutline(shadowSize, layoutDirection, this@drawWithCache))
        }.asAndroidPath()
        val paint = shadowPaint(color, blur.toPx())

        onDrawBehind {
            // offset by x, y then draw
            translate(left = x.toPx() - spreadPx, top = y.toPx() - spreadPx) {
                drawIntoCanvas { canvas ->
                    canvas.nativeCanvas.drawPath(shadowPath, paint)
                }
            }
        }
    }
}

// ------------------------------------------------------------
// Shadow paint: color + blur
// Figma/CSS and Android compute blur differently, so convert the Figma
// blur value to Android so the shadow matches the design.
// ------------------------------------------------------------
private fun shadowPaint(color: Color, blurPx: Float): android.graphics.Paint {
    return android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color.toArgb()

        // Figma/CSS: standard blur = blur / 2
        // Android:   standard blur = radius * 0.57735 + 0.5
        val androidRadius = (blurPx / 2f - 0.5f) / 0.57735f
        if (androidRadius > 0f) {
            maskFilter = BlurMaskFilter(androidRadius, BlurMaskFilter.Blur.NORMAL)
        }
    }
}
