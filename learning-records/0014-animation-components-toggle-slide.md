# Bài 9 (Animation) xong: tự đóng gói 4 component animation có tham số

Hoàn thành Bài 9 (chưa commit lúc review, 2026-10-23), build pass. Người học đặt trang là `ToggleButtonPage` (route `toggle_button`) thay vì `AnimationPage`, và tách luôn thành component trong `ui/components/animation/`:
- `AppToggleButton`: `animateColorAsState` + `animateDpAsState` (màu + radius), chữ đổi bằng `AnimatedContent` + `togetherWith` + `SizeTransform` (bài chưa dạy).
- `AppToggleBox`: `AnimatedVisibility` fadeIn+expandVertically, nhận `content` lambda (slot API).
- `AppFadeBox`: `animateFloatAsState` + `Modifier.alpha` (opacity, vẫn chiếm chỗ).
- `AppSlideUp`: `LaunchedEffect(Unit)` + `delayMillis`, chạy lại bằng `key(playKey)` (tự nghĩ ra cách replay).
- `Modifier.extendHorizontally` dùng `Modifier.layout` để bóng đổ không bị cắt bởi clip của `expandVertically` — rất nâng cao, khả năng có trợ giúp AI.
Đã sửa lỗi Bài 8: `ColorAlPhaBox` giờ làm mờ nền; card dùng `colors.surface`.

**Điểm cần sửa khi review**:
- `AppToggleBox`: `text = if (isVisible) inactiveText else activeText` — tên tham số ngược nghĩa (đang hiện lại dùng "inactive"); nên đổi thành `showText`/`hideText` như `AppFadeBox`.
- `AppFadeBox` chỉ đổi alpha → nội dung ẩn vẫn chiếm chỗ và vẫn bấm được (opacity:0 khác display:none). Chấp nhận nếu cố ý, cần nói rõ.
- `EffectPage` có import thừa `SegmentedButtonDefaults.Icon`; dùng `Icons.AutoMirrored.Filled.ArrowBack` (trái quy ước icon XML).
- Comment `AppSlideUp` ghi "từ trên xuống" nhưng `fullHeight` dương là bắt đầu từ dưới trượt lên.

**Evidence**: đọc các file trên + diff `EffectPage`/`TemplatePage`/`MainActivity`; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học thích tự đóng gói component ngay khi học khái niệm → Bài 10 (`AppCard`) có thể yêu cầu API đầy đủ (slot `content`, tham số shadow). Nên dạy rõ "slot API" (`content: @Composable () -> Unit`) vì họ đã dùng. Xem [[0013-effect-page-custom-boxshadow]].
