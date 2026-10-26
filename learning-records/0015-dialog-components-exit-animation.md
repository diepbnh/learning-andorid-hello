# Bài 10 (Dialog/Modal) xong: AppDialog + AppDialogBottom có animation đóng

Hoàn thành Bài 10 (chưa commit lúc review, 2026-10-26), build pass. `DialogPage` (route `dialog`) có 4 nút: `AlertDialog`, `Dialog`, `AppDialog`, `AppDialogBottom`.

Vượt bài:
- Component dạng slot `content: @Composable ColumnScope.(close: () -> Unit) -> Unit` — truyền hàm `close` vào nội dung để nút bên trong đóng được có animation.
- Animation đóng: `MutableTransitionState` + `LaunchedEffect(isIdle, currentState)` gọi `onDismissRequest` khi fade-out xong (giống `didDismiss` chờ animation của Ionic).
- Tắt dim/animation mặc định của Android qua `DialogWindowProvider.window.setDimAmount(0f)` rồi tự vẽ scrim bằng token mới `colors.backgroundDialog` (Light 0.6, Dark 0.3).
- Bottom sheet có thanh kéo (handle), `animateEnterExit`, `navigationBarsPadding`, `verticalScroll`.

**Điểm cần sửa khi review**:
- Nội dung truyền vào `AppDialog`/`AppDialogBottom` không dùng `close`: chữ "Cancel"/"Submit" chỉ là `Text`, bấm không đóng; bottom sheet không có nút đóng.
- `DarkMode.white = 0xFF000000` (đổi ở một commit trước đó, 19 chỗ dùng `colors.white`) — tên token "white" nhưng Dark Mode là đen → chữ trên nút/banner thành đen. Người học xác nhận **cố ý** (2026-10-26) — không coi là lỗi nữa, không nhắc lại.
- `DialogDimAmount` gọi trong ô `title` của `AlertDialog` (mẹo chạy được nhưng khó hiểu).
- Chưa làm `AppDialog` dạng xác nhận (title/message/confirm) như bài gợi ý — thay bằng slot API tổng quát hơn, chấp nhận được.

**Evidence**: đọc `DialogPage.kt`, `AppDialog.kt`, `AppDialogBottom.kt`, diff `Color.kt`; `git log -L` cho token white; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học thiết kế component theo hướng "khung + slot" rất mạnh; Bài 11 (`AppCard`) có thể đi thẳng vào slot API. Cần dạy design token đặt tên theo công dụng (`onPrimary`) vì lỗi `white`. Xem [[0014-animation-components-toggle-slide]].
