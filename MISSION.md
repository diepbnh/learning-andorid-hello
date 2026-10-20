# Mission: Jetpack Compose UI cho Designer

## Why
Là một Designer thành thạo HTML/CSS, người học muốn tự code và tùy biến UI trực tiếp trên Android Native (Jetpack Compose), thay vì chỉ đưa design cho dev implement. Muốn làm được **mọi thành phần UI mà HTML/CSS có** (ảnh, icon, video, link, form controls, menu, shadow, gradient...) trên app. Project "hello" là demo sống cho khóa học, và là nền để dựng một thư viện component dùng chung cho team (dự án lớn).

## Success looks like
- Tự chạy và debug được UI Android trên thiết bị/emulator: đọc log lỗi, sửa lỗi build, thấy thay đổi UI ngay sau khi sửa code
- Với mỗi thành phần UI quen thuộc từ HTML/CSS, biết thành phần tương đương trong Compose và dựng được nó theo theme của app — xem lộ trình trong `reference/lo-trinh-ui.html`
- Tự tạo được Custom Composable Component (`App...`) cho những thành phần mang style riêng của app và dùng ở nhiều màn hình, trưng bày trong `TemplatePage`
- Dựng được một màn hình hoàn chỉnh trong app thực tế từ đầu đến cuối, không cần chép nguyên mẫu
- Cuối lộ trình: đóng gói component thành thư viện dùng chung, để đồng nghiệp trong team có thể import và tái sử dụng

## Constraints
- Chưa có kiến thức lập trình nền tảng trước khóa học — dạy tư duy lập trình cơ bản *song song* với Compose, không nhảy thẳng vào cú pháp Kotlin nâng cao.
- Lessons viết bằng **Tiếng Việt**; thuật ngữ kỹ thuật (Composable, Modifier, State, Recomposition...) giữ nguyên tiếng Anh, không dịch.
- Dùng tiếp project "hello" (Kotlin + Jetpack Compose, Material3, Navigation Compose); mỗi bài thường là một trang mới + route mới.
- Có trực giác thẩm mỹ và mental model CSS rất mạnh — tận dụng phép so sánh HTML/CSS ⇄ Compose xuyên suốt khóa học.
- Mỗi bài tập có hình minh họa "Kết quả mong đợi".

## Out of scope
- Kiến trúc app nâng cao (MVVM, DI, networking API, database, ViewModel) — chỉ tập trung vào lớp UI/Component. Ngoại lệ tối thiểu: tải ảnh từ URL và phát video (cần thư viện) ở cuối lộ trình.
- Kotlin nâng cao (coroutines, generics, DSL nội bộ) trừ phần tối thiểu cần để đọc hiểu Compose.
- Build release / xuất bản app lên Google Play.
