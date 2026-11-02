# Bài 12 xong: AppCheckbox + AppSwitch theo state hoisting

Hoàn thành Bài 12 (chưa commit lúc review, 2026-11-02), build pass. `ui/components/checkbox/AppCheckbox.kt` (đã đổi tên thư mục từ `checbox`), `ui/components/toggle/AppSwitch.kt`, trang `SettingPage` (route `setting`).

Nắm được state hoisting: cả hai component nhận `checked` + `onCheckedChange`, State ở trang; cả dòng bấm được bằng `toggleable` (có `indication = null`), control bên trong `onCheckedChange = null`. Switch "Dark Mode" nối `ThemeManager`. Tự thêm `enabled`, tham số màu, `gap`; tự tìm `LocalMinimumInteractiveComponentSize` và `Modifier.scale`. Đã chuyển State lên đầu hàm sau khi được góp ý.

**Điểm cần sửa khi review**:
- Nút "Save" chưa gắn `enabled = acceptTerms` → checkbox đồng ý chưa điều khiển nút (mục tiêu chính của bước 3).
- `AppSwitch` thiếu `role = Role.Switch`, thiếu `uncheckedBorderColor` (đã góp ý, chưa làm — nhỏ).
- `notify` khai báo thừa, dùng cho 2 Switch thô.

**Evidence**: đọc `AppCheckbox.kt`, `AppSwitch.kt`, `CheckboxPage.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học cần được hỏi lại "đã nối chưa" ở bước có logic giữa các phần tử (checkbox → nút) — dễ bỏ qua vì UI trông đã xong. Bài 13 (Radio) là chỗ tốt để luyện State một-giá-trị-cho-cả-nhóm. Xem [[0016-appcard-boolean-flags-own-api]].
