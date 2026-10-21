# Bài 7 xong: trang Profile, AppAvatar có shadow, tự làm animation con bướm

Hoàn thành Bài 7 (commits `093b72d`…`8e60191`), build pass. `ProfilePage` dùng `AppPage` (khung trang tự tạo), ảnh bìa trong `Box` + `clip(RoundedCornerShape)` + `ContentScale.Crop`, tên/chức danh, `AppAvatar`, hàng 3 icon (Row + 3 Column `weight`), đoạn giới thiệu dùng `buildAnnotatedString` + `SpanStyle` (in đậm một phần chữ, giống `<b>` trong `<p>`) — tự học, bài chưa dạy.

`AppAvatar` thiết kế API tốt: `size`, `shape` (mặc định `CircleShape`), `borderWidth`/`borderColor`, `shadowElevation`, `contentDescription`; đặt `shadow` **trước** `clip` (đúng thứ tự, nếu clip trước thì bóng bị cắt); viền có điều kiện bằng `Modifier.then(if … else Modifier)`.

Tự làm `ui/components/animation/AppGrassButterfly.kt`: `rememberInfiniteTransition` + `keyframes` (bay qua lại 6s, lật hướng bằng `scaleX = -1`, vỗ cánh bằng `scaleY` 200ms), `graphicsLayer`, `offset`, `clipToBounds` — vượt trước lộ trình (animation là Bài 22).

**Điểm cần sửa khi review**:
- Thêm dependency `material-icons-extended` (file AAR ~36MB) — chính là thứ Google cảnh báo làm build chậm. `Home`, `Favorite`, `Person` đều có trong `material-icons-core`, nên chỉ cần bỏ dòng `extended`.
- Ảnh quá lớn so với kích thước hiển thị: `hinhnen.png` 8001×1431px (~5MB) cho vùng cao 80dp → bitmap giải nén ~45MB RAM; `diep.jpg` 2082×2776px (~1.7MB) cho avatar 80dp. Nguy cơ chậm/tràn bộ nhớ trên máy yếu. Cần export đúng cỡ (≈3× dp) và đổi sang WebP.
- Bước 4 (hàng so sánh ContentScale) và thêm `AppAvatar` nhỏ vào `TemplatePage` chưa làm.
- Hàng 3 icon lặp 3 khối Column giống nhau → ứng viên component (sẽ cần lại ở bottom navigation, Bài 14).

**Evidence**: đọc trực tiếp `ProfilePage.kt`, `AppAvatar.kt`, `AppGrassButterfly.kt`, `build.gradle.kts`; `sips` đo kích thước ảnh; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học tự mở rộng sang rich text và animation — tiếp tục cho tự do khám phá, nhưng cần dạy "tối ưu asset" (kích thước ảnh theo dp/density, WebP) — rất hợp Designer (giống export @1x/@2x/@3x). Xem [[0011-mission-expanded-to-full-html-ui-coverage]].
