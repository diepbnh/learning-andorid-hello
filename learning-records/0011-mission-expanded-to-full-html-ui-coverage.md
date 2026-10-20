# Mission mở rộng: học mọi thành phần UI mà HTML/CSS có

Sau Bài 6, người học yêu cầu các bài tiếp theo bao phủ "những gì bên UI HTML có thì bên app học hết": ảnh, icon, video, link, radio, checkbox, dropdown, side menu, box-shadow, gradient, footer menu...

Đã xác nhận với người học (2026-10-19):
- Đóng gói thư viện component cho team **dời xuống cuối lộ trình** (vẫn là mục tiêu, chưa bỏ).
- Bắt đầu từ Bài 7: Image & Icon, theo thứ tự lộ trình 4 nhóm (Trang trí → Form → Khung app → Media/nâng cao), xem `reference/lo-trinh-ui.html`.
- Người học không tự quyết được chính sách tách component ("kiến thức còn yếu, chọn cái tốt nhất cho dự án lớn của team") → agent chọn: **tách `App...` component khi thành phần mang style riêng của app và dùng ở nhiều màn hình**; thành phần dùng một lần thì dùng trực tiếp. Mỗi component mới được trưng bày trong `TemplatePage`.

Bài 7 (LazyColumn/danh sách) đã đề xuất trước đó được dời thành bài 18 trong lộ trình (`<ul>/<li>` → `LazyColumn`).

**Implications**: MISSION.md đã cập nhật. Bài học tiếp theo nên mỗi bài một nhóm nhỏ thành phần, giữ ngắn, có mockup, so sánh HTML/CSS. Khi người học đề xuất lại thứ tự, điều chỉnh lộ trình chứ không cần hỏi lại mission. Xem [[0010-self-taught-drawbehind-and-list-rendering]].
