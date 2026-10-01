# Tự chọn kiểu validate khi bấm nút, dùng if / else if / else, áp dụng sang LoginPage

Bài 5 gợi ý validate *trực tiếp* (`val isMismatch = ...` tự tính lại khi gõ). Người học chọn cách khác — **validate khi bấm nút Sign up** — và làm rộng hơn yêu cầu:

- 3 State lỗi riêng (`usernameError`, `passwordError`, `confirmPasswordError`, kiểu `String`), `isError = xError.value.isNotEmpty()` suy ra từ chuỗi lỗi — một State chứa cả "có lỗi không" lẫn "nội dung lỗi".
- Chuỗi `if / else if / else` trong `onClick` — lần đầu viết nhiều nhánh điều kiện; nhánh cuối `navigate("template")` khi hợp lệ.
- Xoá lỗi khi người dùng gõ lại (`onValueChange = { x.value = it; xError.value = "" }`) — lambda nhiều câu lệnh, đúng UX chuẩn.
- `AppFormField` thêm `isError`, `errorMessage`, hiện `Text` lỗi bằng `if (isError && errorMessage.isNotEmpty())` — dùng đúng `if` dạng câu lệnh + `&&`.
- Tự áp dụng cùng pattern sang `LoginPage` (dùng `OutlinedTextField` gốc, thêm `errorBorderColor`).

**Lỗi phát hiện khi review** (cùng một gốc: *định nghĩa style lỗi nhưng không bật cờ lỗi*):
- `AppFormField` nhận `isError` nhưng **không truyền xuống `AppTextField`** → viền không bao giờ đỏ, chỉ hiện chữ lỗi.
- `LoginPage`: thêm `errorBorderColor = colors.danger` nhưng không set `isError = ...` trên `OutlinedTextField` → viền cũng không đỏ.
- `LoginPage` dùng `isEmpty()` cho username, `isBlank()` cho password — không nhất quán (`isBlank` bắt cả chuỗi toàn dấu cách).
- `else if` chỉ báo một lỗi mỗi lần bấm (username + password cùng trống → chỉ thấy lỗi username) — quyết định UX, chưa chắc có chủ ý.
- Chưa thêm variant Error vào `TemplatePage` (Bước 3).

**Evidence**: đọc trực tiếp `AppFormField.kt`, `SignUpPage.kt`, diff `LoginPage.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học tự đưa ra quyết định UX/kiến trúc thay vì chép gợi ý — hợp với NOTES.md (thích thử nhiều cách). Lỗi "khai báo tham số nhưng quên truyền xuống" là lỗi mới đáng nhắc khi viết component bọc component (wrapper): mọi tham số nhận vào phải đi đâu đó. Xem [[0007-component-owns-no-outer-spacing]].

**Cập nhật sau sửa**: đã thêm `isError = isError` xuống `AppTextField` trong `AppFormField`; đã thêm variant Error vào `TemplatePage`. Build pass. `LoginPage` vẫn chưa set `isError` cho `OutlinedTextField` (viền chưa đỏ). Giữ `else if` và `isEmpty`/`isBlank` như cũ — không thay đổi.

**Cập nhật 2**: người học không biết cách sửa `LoginPage` → agent sửa hộ: `isError = loginError.value == "Username is required"` (và tương tự cho Password), để chỉ ô bị lỗi đỏ viền, vì `loginError` là một State dùng chung cho cả hai ô. Người học yêu cầu bài tiếp theo là vẽ table (chỉ UI, dữ liệu viết sẵn) → Bài 6; bài đóng gói thư viện dời lại sau.
