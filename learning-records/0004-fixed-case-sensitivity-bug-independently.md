# Tự sửa đúng lỗi phân biệt hoa/thường sau khi được chỉ hướng đọc lỗi build

Sau khi được báo `AppButtonSize.medium` sai case so với enum `Medium` ([[0003-parameterized-enum-transfer-from-primary-source]]), người học tự sửa đúng thành `AppButtonSize.Medium`, không cần chỉ thêm. Đã chạy `./gradlew compileDebugKotlin` xác nhận `BUILD SUCCESSFUL`.

**Evidence**: đọc trực tiếp code sau sửa + tự build lại xác nhận.

**Implications**: Không cần nhắc lại cơ bản về case-sensitivity của Kotlin nữa. Ba bài liên tiếp đều xong đúng vòng lặp "đọc lỗi → sửa → build lại" — đủ nền để Lesson 3 chuyển sang thử thách mới: tự dựng một Composable/màn hình hoàn toàn mới (không chỉ sửa file có sẵn), đúng Goal 3 trong [[MISSION.md]].
