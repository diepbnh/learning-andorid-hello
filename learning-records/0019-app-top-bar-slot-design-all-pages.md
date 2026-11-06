# Bài 14 xong: AppTopBar dạng slot, áp dụng cho 8 trang

Hoàn thành Bài 14 (chưa commit lúc review, 2026-11-06), build pass. Chi tiết quá trình (Part A/B, các lỗi gặp) nằm trong memory `header-lesson`.

`ui/components/layout/AppTopBar.kt`: `CenterAlignedTopAppBar` + `@OptIn`, **slot** `navigationIcon` + `actions: RowScope` (người học tự chọn thay cho `onBack: (() -> Unit)?` của bài, để trang nào cũng đặt được nút trái tuỳ ý), nướng sẵn `boxShadow`, insets ngang 5dp, nền `primary` 0.95, chữ SemiBold 22sp. Header cố định nhờ `topBar` của `AppPage` (người học tự sửa `AppPage`: `verticalScroll` trước padding để nội dung cuộn dưới header). Dùng ở Profile, Radio, Table, ToggleButton, Checkbox, Card (Back), Dialog (Template bên trái), Card2 (Logout trái + Template phải).

**Điểm cần sửa khi review**:
- `ProfilePage`: icon trái là `Home` (đi tới template) nhưng `contentDescription = "Back"` → trình đọc màn hình đọc sai.
- Không nhất quán vị trí nút: Dialog đặt "Template" bên trái (slot Back), Table đặt bên phải.
- Dùng `navigate("template")`/`navigate("login")` để "quay về" → mỗi lần bấm chồng thêm trang vào back stack; quay lại trang trước nên dùng `popBackStack()`.
- Thử thách `pinnedScrollBehavior` chưa làm (tuỳ chọn).

**Evidence**: đọc `AppTopBar.kt`, phần `topBar` của 8 trang; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học thiết kế API slot linh hoạt (giống `AppDialog`) thay vì tham số hẹp — ưu tiên slot khi bài sau có component khung (NavigationBar Bài 17). Navigation back stack là lỗ hổng kiến thức → nên giải thích khi làm footer menu. Xem [[0018-radio-group-ui-only-scope]].
