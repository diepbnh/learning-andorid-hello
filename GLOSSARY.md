# Jetpack Compose UI Glossary

Ngôn ngữ chuẩn dùng trong toàn bộ workspace này. Mọi lesson/reference/learning-record dùng đúng các từ này, không dịch hay đổi tên khác đi.

## Terms

**Composable**:
Một hàm Kotlin đánh dấu `@Composable`, nhận tham số (giống props) và mô tả một phần UI. Tương đương một component web tái sử dụng (React/Vue component), không phải một thẻ HTML đơn lẻ.
_Avoid_: hàm vẽ UI, function UI

**Modifier**:
Một chuỗi (chain) các hàm nối tiếp gắn vào một Composable để mô tả kích thước, khoảng cách, hình dạng, vị trí — tương đương việc gộp nhiều class/inline-style CSS vào một phần tử. Thứ tự nối trong chain có ảnh hưởng tới kết quả.
_Avoid_: thuộc tính style, prop style

**Theme token**:
Một giá trị màu/kích thước lấy từ hệ thống theme của app (ví dụ `colors.primary`, `colors.danger` trong `AppColors`), thay vì viết trực tiếp mã hex/số cứng vào từng Composable. Đổi theme (light/dark) thì mọi nơi dùng token tự đổi theo.
_Avoid_: màu theme, biến màu

**Custom Composable Component**:
Một Composable do project tự viết (không phải của Material3), đặt trong `ui/components/...`, để tái sử dụng nhiều nơi và style theo ý riêng của app — ví dụ `AppButton`, `AppTextField`.
_Avoid_: component riêng, widget custom

**Enum có thuộc tính (parameterized enum)**:
Một `enum class` khai báo constructor, để mỗi case mang sẵn dữ liệu riêng (ví dụ `Small(height = 30.dp, fontSize = 12.sp)`) — dùng khi mỗi lựa chọn cần nhiều giá trị liên quan cùng lúc. Cách này gọn hơn `when` khi việc map không phụ thuộc gì bên ngoài enum. Xem [[0003-parameterized-enum-transfer-from-primary-source]].
_Avoid_: enum có data, enum nâng cao

**Route**:
Một "địa chỉ" dạng chuỗi (ví dụ `"sign_up"`) khai báo bằng `composable("...") { ... }` trong `NavHost`, để `navController` điều hướng tới một màn hình. Tương đương một path URL trên web.
_Avoid_: đường dẫn màn hình, link trang

## Ghi chú

- Chỉ thêm thuật ngữ vào đây **sau khi** người học đã áp dụng đúng nó trong code thật (xem [[0002-applies-theme-tokens-and-reuses-components]]), không thêm chỉ vì mới được giới thiệu trong lesson.
