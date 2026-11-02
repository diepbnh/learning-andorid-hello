# Bài 13 xong (phần UI): AppRadioGroup; người học bỏ qua bước dùng giá trị

Hoàn thành Bài 13 (chưa commit, 2026-11-02), build pass. Tách trang: `SettingPage` → `CheckboxPage` (route `checkbox`), thêm `RadioPage` (route `radio`). `ui/components/radio/AppRadioGroup.kt`: `selectableGroup` + `selectable(role = RadioButton, indication = null)`, `forEach` trên `options: List<String>`, tham số `enabled`, 3 màu, `gap`, `radioScale` (tự thêm, dùng `Modifier.scale`). Tự thử radio thô với `enabled = false` và chữ rất dài.

Người học **chủ động bỏ qua Bước 3** (cỡ chữ xem trước bằng `when … else`): "làm UI này đủ rồi". Tôn trọng — không nhắc lại; `when` với `else` chưa được luyện, có thể gặp lại tự nhiên ở bài sau.

**Điểm cần sửa khi review** (đã báo):
- `Row` trong `AppRadioGroup` thiếu `verticalAlignment = CenterVertically` → chữ lệch lên so với nút 48dp.
- Nút Save ở `CheckboxPage` vẫn chưa có `enabled = acceptTerms` (đã nhắc 2 lần, không nhắc thêm).

**Evidence**: đọc `AppRadioGroup.kt`, `RadioPage.kt`, git status; `./gradlew compileDebugKotlin` pass.

**Implications**: Người học ưu tiên "dựng UI component" hơn "logic nối các phần" — khớp mission (Designer, UI). Bài sau nên giữ phần logic tối thiểu, đặt bước logic là tuỳ chọn. Xem [[0017-checkbox-switch-state-hoisting]].
