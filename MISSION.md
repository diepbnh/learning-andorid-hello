# Mission: Jetpack Compose UI cho Designer

## Why
Là một Designer thành thạo HTML/CSS, người học muốn tự code và tùy biến UI trực tiếp trên Android Native (Jetpack Compose), thay vì chỉ đưa design cho dev implement. Project "hello" hiện tại (LoginPage, ResetPasswordPage, AppButton, AppTextField, ThemeManager) là demo sống cho khóa học, và là nền để dựng một thư viện component dùng chung cho team.

## Success looks like
- Tự chạy và debug được UI Android trên thiết bị/emulator: đọc log lỗi, sửa lỗi build, thấy thay đổi UI ngay sau khi sửa code
- Tự tạo được Custom Composable Component (button, textfield, card, v.v.) với style/theme riêng, tái sử dụng được ở nhiều nơi
- Dựng được một màn hình hoàn chỉnh trong app thực tế (giống LoginPage/ResetPasswordPage) từ đầu đến cuối, không cần chép nguyên mẫu
- Đóng gói component thành thư viện dùng chung, để đồng nghiệp trong team có thể import và tái sử dụng

## Constraints
- Chưa có kiến thức lập trình nền tảng — chưa từng viết biến/hàm/điều kiện/vòng lặp ở bất kỳ ngôn ngữ nào. Cần dạy tư duy lập trình cơ bản *song song* với Compose, không nhảy thẳng vào cú pháp Kotlin nâng cao.
- Lessons viết bằng **Tiếng Việt**; thuật ngữ kỹ thuật (Composable, Modifier, State, Recomposition...) giữ nguyên tiếng Anh, không dịch.
- Đã có sẵn project "hello" (Kotlin + Jetpack Compose, Material3, Navigation Compose) — ưu tiên dùng lại code có sẵn (LoginPage, AppButton, AppTextField, ThemeManager) làm ví dụ và bài tập, thay vì tạo project mới.
- Có trực giác thẩm mỹ và mental model CSS rất mạnh — tận dụng phép so sánh HTML/CSS ⇄ Compose xuyên suốt khóa học để giảm tải nhận thức.

## Out of scope
- Kiến trúc app nâng cao (MVVM, DI, networking, database, ViewModel phức tạp) — chỉ tập trung vào lớp UI/Component cho tới khi 3 mục tiêu chính đạt được.
- Kotlin nâng cao (coroutines, generics, DSL nội bộ) trừ phần tối thiểu cần để đọc hiểu Compose.
- Build release / xuất bản app lên Google Play — ngoài phạm vi demo khóa học này.
