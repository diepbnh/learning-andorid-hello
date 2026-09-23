# Tự chuyển pattern enum+when sang bài toán khác, và tìm ra cách tốt hơn gợi ý

Ở bài 2, gợi ý ban đầu là `enum class AppButtonSize` rồi viết `toHeight()`/`toMinWidth()` bằng `when`. Người học tự viết lại `AppButtonSize.kt` theo cách khác — và tốt hơn:

```kotlin
enum class AppButtonSize(val height: Dp, val fontSize: TextUnit) {
    Small(height = 30.dp, fontSize = 12.sp),
    Medium(height = 50.dp, fontSize = 16.sp),
    Large(height = 70.dp, fontSize = 30.sp),
}
```

Enum mang thuộc tính riêng trong constructor, không cần `when` để map. Đây đúng là ví dụ đầu tiên trong tài liệu chính thức ([Enum classes — kotlinlang.org](https://kotlinlang.org/docs/enum-classes.html), đã có trong [[RESOURCES.md]]) — bằng chứng người học đã tự đọc nguồn chính thức thay vì chỉ theo hint, và chọn đúng pattern phù hợp hơn khi mỗi case cần *nhiều* giá trị cùng lúc.

**Lỗi phát hiện khi review**: gọi `AppButtonSize.medium` (chữ thường) trong khi enum case là `Medium` (viết hoa) — lỗi cú pháp thuần túy (Kotlin phân biệt hoa/thường), không phải hiểu sai khái niệm. Đáng ghi nhận vì đây là lỗi phổ biến của người mới — cần một vòng build để tự thấy `Unresolved reference`.

**Implications**: Từ giờ dạy pattern "enum có thuộc tính trong constructor" làm mặc định khi mỗi case cần nhiều giá trị liên quan (size, spacing...), chỉ dùng `when` riêng khi logic map phụ thuộc điều kiện bên ngoài enum (ví dụ đọc theme sáng/tối như `toColor()`). Cũng nên nhắc lại: Kotlin phân biệt hoa/thường ở tên hằng số — lỗi hay gặp, không cần dạy lại từ đầu, chỉ cần nhắc khi xuất hiện.
