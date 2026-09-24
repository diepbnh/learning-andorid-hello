# Sửa đúng: component không tự áp khoảng cách bên ngoài

Sau review [[0006-extracted-appformfield-with-if-expression]], người học:

- Xóa `Spacer` khỏi thân `AppFormField`, chuyển `Spacer(20.dp)` ra giữa các lời gọi trong `SignUpPage` — hiểu đúng nguyên tắc "khoảng cách bên ngoài do nơi gọi quyết định" (tương đương auto-layout gap ở frame cha trong Figma).
- Thêm `AppFormField` vào `TemplatePage` (hiện dùng `value = ""`, `onValueChange = {}` — ô trưng bày tĩnh, gõ không hiện chữ; chấp nhận được cho catalog).
- Giữ `navigate("login")` ở `ResetPasswordPage` **có chủ ý**, kèm comment tự viết so sánh với `popBackStack()` (xem NOTES.md).

**Evidence**: đọc trực tiếp code sau sửa; `./gradlew compileDebugKotlin` pass.

**Implications**: Bài 5 — báo lỗi Confirm Password không khớp: giới thiệu `==`/`!=`/`&&`/`isNotEmpty()`, `if` dạng câu lệnh (không cần `else`) đối lập với `if` dạng giá trị ở bài 4, và giá trị suy ra từ State tự tính lại khi Recomposition. Thêm variant "Error" vào `TemplatePage` để catalog thể hiện mọi trạng thái của component.
