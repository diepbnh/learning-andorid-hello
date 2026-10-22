# Bài 8 xong: EffectPage, tự làm boxShadow kiểu Figma, tách box có tham số

Hoàn thành Bài 8 (commit `6cb8f45`), build pass. `EffectPage` có banner gradient dùng color stop (`0f to …, 0.9f to …`, tự học), ảnh có lớp phủ `copy(alpha)` + `matchParentSize`, 3 card shadow (mặc định, `ambientColor`/`spotColor`, custom), 2 hàng alpha.

Vượt bài: tự viết `ui/theme/Shadow.kt` — `Modifier.boxShadow(color, x, y, blur, spread, shape)` theo thông số Figma, `drawWithCache` + `BlurMaskFilter`, có quy đổi blur Figma → Android và fallback `shadow()` dưới Android 9. Dùng `Card` sớm (Bài 9). Tự tách `AlphaBox`/`ColorAlPhaBox` có tham số + `modifier` nhận `weight` từ `Row`. Thêm `scrollable` vào `AppPage` bằng `Modifier.then(if …)`. Tự thêm `.gitignore`, gỡ file cache khỏi git.

**Điểm cần sửa khi review**:
- Chưa làm Bước 2 (token `surface`): card dùng `containerColor = colors.white` + `contentColor = colors.text` → Dark Mode chữ trắng trên nền trắng, không đọc được.
- `ColorAlPhaBox` làm mờ **chữ** (`textAlPha`), nền giữ 1f — ngược yêu cầu (nền mờ, chữ rõ); nhãn ghi "chữ vẫn rõ" nhưng code không khớp.
- Lớp phủ ảnh dùng trắng 50% thay gradient tối — chấp nhận được về thiết kế, nhưng chữ không đặt màu, Dark Mode có thể chìm.
- Nhỏ: typo `BoxWellcome`, `colo.copy`, import thừa.

**Evidence**: đọc `EffectPage.kt`, `Shadow.kt`, `AppPage.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học (có thể với trợ giúp AI) đã nghĩ theo hướng thông số Figma — tận dụng cho design token (shadow token) khi làm `AppCard` ở Bài 9. Cần nhắc kiểm tra Dark Mode mỗi bài. Xem [[0012-profile-page-images-icons-animation]].
