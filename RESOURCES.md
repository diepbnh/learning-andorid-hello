# Jetpack Compose UI (for Designers) Resources

## Knowledge

- [Thinking in Compose — Android Developers](https://developer.android.com/develop/ui/compose/mental-model)
  Tài liệu chính thức giải thích mental model của Compose: declarative UI, composable function, recomposition. Dùng cho: bài học đầu tiên khi giải thích "vì sao Compose khác HTML tĩnh".
- [Jetpack Compose basics — Codelab chính thức](https://developer.android.com/codelabs/jetpack-compose-basics)
  Codelab thực hành từng bước: composable, layout, state, theming, xây một app nhỏ từ đầu. Dùng cho: primary source của các lesson về composable cơ bản và state.
- [Basic layouts in Compose — Codelab](https://developer.android.com/codelabs/jetpack-compose-layouts)
  Thực hành Row/Column/Box và Modifier — phần tương đương với `display: flex` / `box model` trong CSS. Dùng cho: lesson về layout, khi so sánh với CSS box model.
- [State in Jetpack Compose — Codelab](https://developer.android.com/codelabs/jetpack-compose-state)
  Giải thích `remember`, `mutableStateOf`, luồng dữ liệu một chiều. Dùng cho: lesson về tương tác UI (form nhập liệu, giống LoginPage hiện có).
- [Jetpack Compose for Android Developers — lộ trình đầy đủ](https://developer.android.com/courses/jetpack-compose/course)
  Lộ trình chính thức của Google, dùng để tra cứu module tiếp theo khi đã xong các phần cơ bản.
- [Kotlin Tour — kotlinlang.org](https://kotlinlang.org/docs/kotlin-tour-welcome.html)
  Tour tương tác ngay trên browser (không cần cài gì), dạy biến, hàm, điều kiện, class ở mức tối thiểu. Dùng cho: các lesson "tư duy lập trình cơ bản" xen giữa các lesson Compose, vì người học chưa từng viết code logic.
- [Kotlin Basic syntax — kotlinlang.org](https://kotlinlang.org/docs/basic-syntax.html)
  Tài liệu tra cứu cú pháp nhanh (biến `val`/`var`, hàm, class, lambda). Dùng cho: reference doc cheat-sheet cú pháp Kotlin.
- [Enum classes — kotlinlang.org](https://kotlinlang.org/docs/enum-classes.html)
  Tài liệu chính thức về `enum class` và cách dùng cùng `when` để map từng giá trị enum sang một kết quả (ví dụ màu). Cũng là nơi có ví dụ enum mang thuộc tính riêng trong constructor. Dùng cho: Lesson 2 — xây hệ thống variant cho `AppButton`.
- [Navigation with Compose — Android Developers](https://developer.android.com/develop/ui/compose/navigation)
  Tài liệu chính thức về `NavController`/`NavHost`/route. Dùng cho: Lesson 3 — thêm một màn hình mới vào nav graph.
- [Navigate between screens with Compose — Codelab](https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation)
  Thực hành thêm route mới, truyền tham số giữa các màn hình. Dùng cho: Lesson 3, nếu muốn thực hành thêm ngoài bài học.

- [Compose component API guidelines — AndroidX](https://android.googlesource.com/platform/frameworks/support/+/androidx-main/compose/docs/compose-component-api-guidelines.md)
  Hướng dẫn chính thức của team Compose về thiết kế API component: thứ tự tham số, `modifier`, giá trị mặc định. Dùng cho: Lesson 4 (tách `AppFormField`) và các bài đóng gói thư viện component.
- [Back stack — Android Developers](https://developer.android.com/guide/navigation/backstack)
  Giải thích `navigate` đẩy màn lên stack và `popBackStack` quay lại. Dùng cho: Lesson 4 (sửa link "Login").
- [Control flow: if expression — kotlinlang.org](https://kotlinlang.org/docs/control-flow.html#if-expression)
  `if` dùng như biểu thức trả về giá trị. Dùng cho: Lesson 4 (`isPassword`).

## Wisdom (Communities)

- [r/androiddev](https://reddit.com/r/androiddev)
  Subreddit lớn, có mod, nhiều thảo luận sâu về Compose/kiến trúc. Dùng cho: khi cần hỏi ý kiến thực chiến ngoài phạm vi khóa học (ví dụ: convention đặt tên component, cách chia module).
- [Android Developers Blog](https://android-developers.googleblog.com/)
  Blog chính thức, cập nhật thay đổi API Compose theo từng release. Dùng cho: kiểm tra API có bị deprecate/thay đổi hay không trước khi viết lesson mới.

## Gaps

- Chưa tìm được một community tiếng Việt (Facebook group/Discord) đủ uy tín và còn hoạt động để xác nhận qua tìm kiếm — cần người học tự đề xuất nếu có group quen biết, hoặc sẽ tìm lại sau khi khóa học tiến xa hơn.
