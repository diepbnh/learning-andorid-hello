# Tự áp dụng theme token và tái sử dụng component — vượt xa yêu cầu bài 1

Sau [[0001-no-prior-programming-strong-css]], người học không chỉ làm đúng bài tập của Lesson 1 (đổi text/màu trong `LoginPage.kt`) mà còn tự:

- Thay toàn bộ màu hex cứng (`Color(0xFF1a75cf)`) bằng theme token (`colors.primary`, `colors.light`) — đúng bản năng thiết kế hệ thống của một Designer, tự nhận ra "màu nên đi qua theme, không hardcode".
- Thay `Button` gốc của Material bằng `AppButton` — component tái sử dụng của project — thay vì viết lại UI button từ đầu. Đúng tinh thần Goal 3 trong [[MISSION.md]] (dùng chung component).
- Tự thêm một Row 2 nút Light/Dark Mode, dùng `Modifier.weight(1f)` để chia đều chiều ngang — cú pháp **chưa được dạy** trong Lesson 1, tự suy ra được từ việc đọc code có sẵn.
- Sửa `Theme.kt` để bọc `content` trong `Surface(color = colors.backgroundBody)` — hiểu đúng rằng nền toàn app cũng phải đi qua theme, không phải chỉ text/button.
- Bắt đầu (nhưng bỏ dở, hiện đang comment) một `enum class AppButtonColors` trong `AppButtonColors.kt` — dấu hiệu rõ đang cần một cách "chọn variant màu" cho component, đúng lúc cho Lesson 2.

**Evidence**: đọc trực tiếp diff code trong `LoginPage.kt`, `Theme.kt`, `AppButtonColors.kt` — không chỉ qua lời kể.

**Implications**: Không cần dạy lại "Modifier là gì" hay "sao phải dùng component có sẵn" — đã hiểu và áp dụng đúng. Lesson 2 nên đi thẳng vào việc hoàn thiện `AppButtonColors.kt`: dạy `enum class` + `when` (đã có sẵn ví dụ tương tự trong `appTextFieldBorderColor` ở `AppTextField.kt` — dùng lại đúng file này làm cầu nối) để tạo hệ thống variant cho component, đúng Goal 2 trong [[MISSION.md]].
