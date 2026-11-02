# Bài 11 xong: AppCard với API riêng (hasShadow/hasBorder thay cho enum)

Hoàn thành Bài 11 (chưa commit lúc review, 2026-10-30), build pass. `ui/components/card/AppCard.kt` + trang trưng bày `Card2Page` (route `card2`, 6 card).

Người học **tự chọn thiết kế khác bài**: thay `enum AppCardVariant` bằng 2 cờ `hasShadow`/`hasBorder` → kết hợp được cả bóng + viền (bài dùng enum thì không). Đúng với cách họ mô tả ý tưởng ("có shadow hoặc không, có outline hoặc không"). Tham số đầy đủ kiểu Figma: `shadowX/Y/Blur/Spread/Color` dùng `boxShadow` của họ, `borderColor/Width`, `backgroundColor`, `textColor`, `cornerRadius`, `contentPadding`.

Theme: đổi tên `surface` → `backgroundCard` (đồng bộ với `backgroundBody`, `backgroundDialog`); thêm token `black`; không thêm token `border` (mặc định viền = `colors.primary`, nên Dark Mode vẫn thấy). `boxShadow` giờ bắt buộc truyền `color`.

**Điểm cần sửa khi review**:
- 4 chỗ `Card(...)` cũ (`CardPage` ×3, `ToggleButtonPage` ×1) được **cố ý giữ lại** để so sánh cách viết cũ/mới (người học xác nhận) — không nhắc lại.
- Nhỏ: `AppCard() { }` → có thể bỏ `()` khi chỉ có lambda.

**Evidence**: đọc `AppCard.kt`, `Card2Page.kt`, diff theme; grep `Card(`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học đã đủ tự tin để thiết kế API component khác gợi ý và có lý do — bài sau nên đưa ra yêu cầu (giống nhau/khác nhau) và để họ chọn API, rồi review. Lưu ý dùng `backgroundCard` (không còn `surface`) trong bài/mockup sau. Xem [[0015-dialog-components-exit-animation]].
