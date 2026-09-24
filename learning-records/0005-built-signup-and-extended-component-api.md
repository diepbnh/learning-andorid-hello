# Tự dựng SignUpPage và tự mở rộng API của AppTextField

Hoàn thành Bài 3: tạo `SignUpPage.kt` mới hoàn toàn, thêm route `sign_up` vào `NavHost`, thêm link từ `LoginPage`. Build thành công (`./gradlew compileDebugKotlin`). Vượt yêu cầu ở ba điểm:

- **Tự thêm tham số mới cho một Custom Composable Component**: thêm `visualTransformation: VisualTransformation = VisualTransformation.None` vào `AppTextField` rồi truyền xuống `BasicTextField` — lần đầu *sửa chữ ký hàm* của component (không chỉ gọi nó), có giá trị mặc định để không làm hỏng các chỗ gọi cũ. Đây là câu hỏi Bài 3 để ngỏ ("ẩn ký tự mật khẩu") và người học tự giải quyết.
- Tự thêm hiển thị placeholder (`if (value.isEmpty()) Text(...)`), `textStyle`, `cursorBrush` theo theme token cho `AppTextField`.
- Tự tạo `TemplatePage.kt` + route `template`: một trang trưng bày các size/màu của `AppButton` — về bản chất là một component catalog (kiểu Storybook / trang component trong Figma), chưa ai dạy.

**Lỗi/điểm chưa tốt khi review**:
- Link "Login" ở `SignUpPage` dùng `navController.navigate("login")` → chồng thêm một Login mới lên back stack (bấm Back sẽ quay lại Sign Up). Nên dùng `popBackStack()`. Cùng lỗi có sẵn trong `ResetPasswordPage`.
- `AppTextField(value: String = "", ...)` — cho `value` giá trị mặc định là rủi ro: quên truyền `value` thì build vẫn qua nhưng gõ không hiện chữ.
- Khối "Text label + AppTextField + Spacer" lặp 3 lần trong `SignUpPage` — ứng viên tách component.
- Commit `00ee6f9` đưa cả `.gradle/`, `.idea/`, `.DS_Store`, build report vào git — chưa có `.gitignore` phù hợp. Ngoài phạm vi UI nhưng sẽ quan trọng khi chia sẻ thư viện cho team (Goal 4 trong [[MISSION.md]]).

**Evidence**: đọc trực tiếp `SignUpPage.kt`, `TemplatePage.kt`, `MainActivity.kt`, diff `AppTextField.kt` trong commit `00ee6f9`; build pass.

**Implications**: Goal 3 (dựng màn hình hoàn chỉnh) đạt mức đầu. Người học đã sẵn sàng *thiết kế API component* chứ không chỉ dùng. Bài 4: tách khối lặp thành `AppFormField` (tham số `label`, `isPassword`), giới thiệu `if/else` như một giá trị, sửa nhanh `popBackStack()`. `TemplatePage` là mầm của component catalog — nên dùng tiếp làm nơi trưng bày mỗi component mới, dẫn tới Goal 4. Xem [[0004-fixed-case-sensitivity-bug-independently]].
