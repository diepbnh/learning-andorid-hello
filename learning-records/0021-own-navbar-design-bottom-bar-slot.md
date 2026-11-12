# Bài 16 xong: AppBottomBar (slot) + AppNavBar tự thiết kế, không dùng NavigationBar

Hoàn thành Bài 16 (commits `85d6741`, `bf6bd77`, 2026-11-12), build pass. Làm Loại 2 trước (theo lựa chọn của người học), rồi Loại 1.

- `AppBottomBar`: `Column` slot `ColumnScope`, bóng `colors.light` blur 20 quanh khung (không bo góc như bài — lựa chọn thiết kế riêng), nền `backgroundBody`, `navigationBarsPadding`. Dùng thử trong `CheckboxPage`.
- `AppNavBar`: **tự thiết kế** thay cho Material `NavigationBar` — `Row(SpaceBetween)` + `private AppNavBarButton` vuông `buttonSize` 70dp, chọn → nền `primary`, chưa chọn → nền `white` + bóng (`hasShadow`). `onClick` dùng đúng công thức `popUpTo("home") { saveState }` + `launchSingleTop` + `restoreState`. Thêm `HomePage` (route `home`) có `AppDrawer` + `AppTopBar` + `AppNavBar`, nội dung là danh sách `AppCard` giống ảnh Figma CarMD.
- Code app giờ viết comment/chuỗi bằng tiếng Anh (memory `code-language-english`).

**Điểm cần sửa khi review**:
- Chỉ `HomePage` có `AppNavBar`; 3 tab còn lại (`card`, `profile`, `checkbox`) chưa gắn → bấm tab sang trang khác thì thanh tab biến mất.
- `Icon(contentDescription = item.label)` + `Text(item.label)` → trình đọc màn hình đọc 2 lần; nên `null`.
- 4 nút × 70dp + padding 48dp = 328dp: vừa máy 360dp, nhưng 5 nút sẽ tràn — cân nhắc `weight(1f)` khi cần 5 nút.
- `VerifyPage` (bước 4) chưa tạo — đã thực hành `AppBottomBar` ở `CheckboxPage` thay thế.

**Evidence**: đọc `AppBottomBar.kt`, `AppNavBar.kt`, `HomePage.kt`, routes trong `MainActivity.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học đủ tự tin bỏ component Material để tự dựng theo Figma, đồng thời giữ được phần logic quan trọng (back stack). Bài sau có thể đưa yêu cầu thiết kế + Material component như một lựa chọn, để họ tự chọn. Xem [[0020-app-drawer-logo-danger-items]].
