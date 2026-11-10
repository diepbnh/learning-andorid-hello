# Bài 15 xong: AppDrawer có logo, phần giữa cuộn, mục Logout màu đỏ

Hoàn thành Bài 15 (commit `1e14932` + chỉnh sửa chưa commit, 2026-11-10), build pass. `ui/components/layout/AppDrawer.kt` dùng ở Menu, Template, Profile, Card2. Tự thêm: logo vector `res/drawable/logo.xml` (tải từ Figma), `DrawerHeader`/`DrawerFooter` dạng `private` Composable, phần giữa `Column(weight(1f).verticalScroll)` để header/footer đứng yên, cờ `isDanger` cho mục Logout, `shape` item gần vuông (1dp), icon 26dp.

**Điểm cần sửa khi review**:
- `unselectedContainerColor = colors.white` → ở Dark Mode `white` là đen (cố ý) nên mỗi mục chưa chọn thành thanh đen trên nền card xám; nên dùng `Color.Transparent`.
- Logout `navigate("login")` không xoá lịch sử → Back từ Login quay lại app; cần `popUpTo(0) { inclusive = true }` hoặc tương tự.
- `MenuPage` vẫn tự viết `scope.launch` + nút ☰ thay vì dùng `AppMenuButton` (chưa tạo); `contentDescription = "BOpen Menu"` (typo).
- Nhiều mục dùng chung icon `Settings` (Card, Card 2, Template) → khó phân biệt.

**Evidence**: đọc `AppDrawer.kt`, `MenuPage.kt`, `logo.xml`; grep nơi dùng `AppDrawer(`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học tự tách sub-component private và nghĩ về bố cục 3 vùng (header/scroll/footer) — chuẩn bị tốt cho Bài 16 footer. Navigation back stack giờ là vấn đề thật ở 3 nơi → Bài 16 dạy `popUpTo`/`launchSingleTop`/`restoreState`. Xem [[0019-app-top-bar-slot-design-all-pages]].
