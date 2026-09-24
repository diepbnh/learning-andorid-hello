# Tự tách AppFormField, dùng đúng if-expression và popBackStack

Hoàn thành Bài 4 (commit `e5f0fc0`, `919a6eb`), build pass:

- Tạo `ui/components/textfield/AppFormField.kt` đúng khung: truyền `modifier` vào `Column` (không tạo `Modifier` mới), `visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None` — dùng đúng `if` như một giá trị ngay lần đầu.
- Thay 3 khối lặp trong `SignUpPage` bằng 3 lời gọi `AppFormField`.
- Đổi link quay lại trong `SignUpPage` và `TemplatePage` sang `popBackStack()`, tự viết comment giải thích.
- Bỏ giá trị mặc định của `value` trong `AppTextField`.

**Chưa làm / điểm cần sửa khi review**:
- Đặt `Spacer(height = 20.dp)` *bên trong* `AppFormField` → component tự áp khoảng cách bên ngoài lên mọi nơi dùng (giống nhét `margin-bottom` vào component, hay chèn khoảng trống vào trong Figma component thay vì dùng auto-layout gap ở frame cha). Khoảng cách nên do nơi gọi quyết định (qua `Spacer` ở màn hình hoặc `modifier`). Đây là một bài học design-system đúng lúc, vì Designer có sẵn trực giác này từ auto-layout.
- `ResetPasswordPage.kt:94` vẫn dùng `navigate("login")` — người học **chủ động giữ lại** để so sánh hai cách điều hướng (xem NOTES.md), không phải lỗi sót.
- Chưa thêm `AppFormField` vào `TemplatePage` (Bước 3).

**Evidence**: đọc trực tiếp `AppFormField.kt`, `SignUpPage.kt`, grep toàn bộ `navigate`/`popBackStack`/`AppFormField`; `./gradlew compileDebugKotlin` pass.

**Implications**: `if`-expression và thiết kế tham số component đã nắm. Bước tiếp theo trong ZPD: (1) nguyên tắc "component không tự áp khoảng cách bên ngoài" (sửa nhanh); (2) Bài 5 có thể dùng `isError` sẵn có của `AppTextField` + `if` để báo lỗi khi Confirm Password không khớp — lần đầu viết logic so sánh giá trị state. Xem [[0005-built-signup-and-extended-component-api]].
