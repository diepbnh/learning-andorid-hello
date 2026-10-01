# Tự dựng table bằng VerticalDivider + IntrinsicSize, tự học pressed state

Bài 6: tạo `TablePage.kt` (route `table`), build pass. Người học **không theo cách viền-mỗi-ô** trong bài mà chọn cách của tài liệu chính thức: `VerticalDivider` giữa các ô + `HorizontalDivider` giữa các hàng, `Row(Modifier.height(IntrinsicSize.Min))` để đường dọc cao bằng hàng — hiểu đúng vai trò của `IntrinsicSize.Min`. Tự chọn weight 1.5f / 1f / 1f, header chữ trắng dùng divider trắng, và cố ý đặt một ô chữ dài ("Car 01 dummy dummy") để thử xuống dòng.

Tự làm thêm ngoài bài:
- Link "Back" đổi màu khi đang nhấn: `MutableInteractionSource` + `collectIsPressedAsState()` + `color = if (isPressed) colors.secondary else colors.primary`, tắt ripple bằng `indication = null` — dùng `if`-expression đúng chỗ, và tái dùng pattern `interactionSource` đã thấy trong `AppTextField`.
- Thêm theme token mới `backgroundTextField` (light/dark) vào `AppColors` và dùng trong `AppTextField` — tự mở rộng hệ thống theme.
- Đổi `startDestination = "table"` để mở thẳng trang đang làm (mẹo dev; cần trả về `"login"` sau).

**Điểm cần sửa khi review**:
- Text ô dữ liệu không set `color` → mặc định đen (vì `Surface(color = colors.backgroundBody)` không phải màu Material nên content color rơi về đen) → **gần như vô hình ở Dark Mode**. Gốc rễ nằm ở `Theme.kt`: nên set `contentColor = colors.text` cho `Surface` (giống `body { color }` trong CSS) — sửa một chỗ cho toàn app.
- Hàng 2 thiếu `fillMaxWidth()` và có `fillMaxHeight()` thừa (không ảnh hưởng hiển thị vì weight tự lấp đầy, nhưng không nhất quán với các hàng khác).
- Bước 4 (tách `AppTableCell`) và zebra chưa làm; 4 hàng × 3 ô copy-paste, mỗi ô lặp `.weight(..).padding(15.dp)`.

**Evidence**: đọc trực tiếp `TablePage.kt`, `Theme.kt`, diff `Color.kt`/`AppTextField.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học đọc được tài liệu chính thức và chọn giải pháp khác bài một cách có căn cứ — tiếp tục cho họ tự do chọn cách (NOTES.md). Khái niệm mới đáng dạy: content color mặc định / `contentColor` của Surface (tương đương `color` kế thừa trong CSS). Xem [[0008-submit-time-validation-own-design]].

**Cập nhật sau sửa**: đã thêm `contentColor = colors.text` vào `Surface` trong `Theme.kt` (sửa gốc, đúng hướng) và trả `startDestination` về `"login"`. Chưa sửa Row 2, chưa làm `AppTableCell`/zebra. Phát hiện mới ở `LoginPage`: `import android.R` thừa (auto-import nhầm, che `R` của app); `focusedContainerColor/unfocusedContainerColor = colors.white` hardcode trắng thay vì dùng token `backgroundTextField` chính họ vừa tạo → ô trắng lạc tông ở Dark Mode; nếu đổi sang token (đen ở dark) thì cần thêm `focusedTextColor/unfocusedTextColor = colors.text`.
