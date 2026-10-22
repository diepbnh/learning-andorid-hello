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
// boxShadow — BÓNG DÙNG CHUNG, gọi được từ mọi trang / component
//    Giống Figma "Drop shadow" / CSS box-shadow: x y blur spread color
//
//   color  : màu bóng (có thể kèm độ mờ: color.copy(alpha = 0.25f))
//   x      : lệch ngang   (Figma X)
//   y      : lệch dọc     (Figma Y)
//   blur   : độ nhòe      (Figma Blur) — chép nguyên số từ Figma
//   spread : nở rộng ra   (Figma Spread), số âm = thu nhỏ: (-4).dp
//   shape  : hình của phần tử — truyền ĐÚNG shape của Card/Box/...
//
// Figma không có thông số nào thì bỏ không truyền, sẽ lấy mặc định.
// Nhiều lớp bóng thì nối nhiều .boxShadow(...) liên tiếp.
//
// Android 9+      -> vẽ đúng theo thông số
// Dưới Android 9  -> tự lùi về shadow() có sẵn (bóng đen, gần đúng)
// ============================================================
fun Modifier.boxShadow(
    color: Color = Color.Black.copy(alpha = 0.25f),// màu bóng
    x: Dp = 0.dp, // lệch ngang
    y: Dp = 0.dp, // lệch dọc
    blur: Dp = 0.dp,// độ nhòe
    spread: Dp = 0.dp, // nở rộng
    shape: Shape = RectangleShape,// hình của component
): Modifier {
    // Máy cũ: GPU không hỗ trợ làm nhòe -> dùng shadow() có sẵn
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
        return this.shadow(elevation = y + blur / 2, shape = shape, clip = false)
    }

    // Máy mới: tự vẽ bóng phía sau phần tử
    // drawWithCache: chỉ tạo lại hình bóng khi kích thước phần tử thay đổi
    return this.drawWithCache {
        val spreadPx = spread.toPx()

        // hình bóng = hình phần tử + spread
        val shadowSize = Size(
            (size.width + spreadPx * 2).coerceAtLeast(0f),
            (size.height + spreadPx * 2).coerceAtLeast(0f),
        )
        val shadowPath = Path().apply {
            addOutline(shape.createOutline(shadowSize, layoutDirection, this@drawWithCache))
        }.asAndroidPath()
        val paint = shadowPaint(color, blur.toPx())

        onDrawBehind {
            // dời theo x, y rồi vẽ
            translate(left = x.toPx() - spreadPx, top = y.toPx() - spreadPx) {
                drawIntoCanvas { canvas ->
                    canvas.nativeCanvas.drawPath(shadowPath, paint)
                }
            }
        }
    }
}

// ------------------------------------------------------------
// Bút vẽ bóng: màu + độ nhòe
// Figma/CSS và Android tính độ nhòe khác nhau, nên đổi số blur
// của Figma sang số của Android để bóng nhòe giống thiết kế.
// ------------------------------------------------------------
private fun shadowPaint(color: Color, blurPx: Float): android.graphics.Paint {
    return android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color.toArgb()

        // Figma/CSS: độ nhòe chuẩn = blur / 2
        // Android:   độ nhòe chuẩn = radius * 0.57735 + 0.5
        val androidRadius = (blurPx / 2f - 0.5f) / 0.57735f
        if (androidRadius > 0f) {
            maskFilter = BlurMaskFilter(androidRadius, BlurMaskFilter.Blur.NORMAL)
        }
    }
}
