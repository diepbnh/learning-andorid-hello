# Tự tách AppTableCell bằng drawBehind, tự học data class + forEachIndexed

Hoàn tất Bài 6 (commit `e53c52c` + thay đổi chưa commit trong `TablePage.kt`), build pass. `TablePage` giờ có 3 bảng để so sánh 3 cách (đúng sở thích "giữ nhiều cách" trong NOTES.md):

1. Bảng 1: `VerticalDivider`/`HorizontalDivider` viết tay, đã sửa Row 2 (`fillMaxWidth`, bỏ `fillMaxHeight`), thêm zebra `colors.light` cho hàng 2 và 4.
2. Bảng 2: dùng `ui/components/table/AppTableCell.kt`. Người học **không dùng `border` mỗi ô như bài gợi ý** mà tự viết `Modifier.drawBehind { drawLine(...) }` chỉ vẽ cạnh phải + cạnh dưới — tránh viền đôi giữa hai ô. Tự hiểu được giới hạn: phải đọc `colors` ra biến *trước* `drawBehind` vì trong khối vẽ không gọi được hàm `@Composable` (tự ghi comment). Có thêm một hàng thử "gộp cột" bằng weight 3f/4f.
3. Bảng 3: **tự học render từ dữ liệu** — `data class Product(name, number, price)`, `val products = listOf(...)`, `products.forEachIndexed { index, product -> Row {...} }`, zebra bằng `if (index % 2 == 0) Color.Transparent else colors.light`. Vượt phạm vi họ tự đặt ("chưa cần đổ dữ liệu động") — tức là đã sẵn sàng cho chủ đề list data.

Thêm `verticalScroll(rememberScrollState())` cho trang dài.

**Điểm cần sửa khi review**:
- Hàng "gộp cột" weight 3f/4f không thẳng với lưới 1.5f/1f/1f. Muốn ô gộp 2 cột cuối thì weight phải bằng *tổng* weight các cột bị gộp: 1.5f và 2f (giống `colspan` / `grid-column: span 2`).
- Bảng 2: các ô dữ liệu cột Number/Price thiếu `textAlign = TextAlign.End` trong khi header căn phải.
- `LoginPage` vẫn còn `import android.R` và `colors.white` cho container (góp ý ở [[0009-table-with-dividers-own-approach]] chưa làm).
- Còn thay đổi chưa commit (`TablePage.kt`, `Font.kt`, `Type.kt`).

**Evidence**: đọc trực tiếp `AppTableCell.kt`, `TablePage.kt`, diff `Font.kt`/`Type.kt`; `./gradlew compileDebugKotlin` pass.

**Implications**: Zone of proximal development đã dịch chuyển: người học tự đọc được API vẽ (`drawBehind`, `Offset`, `drawLine`) và vòng lặp danh sách. Bài tiếp theo hợp lý: (a) chính thức hoá list data — `data class`, `listOf`, `forEach` vs `LazyColumn` (khi nào cần), hoặc (b) quay lại đóng gói thư viện component (Goal 4). Hỏi người học chọn.
