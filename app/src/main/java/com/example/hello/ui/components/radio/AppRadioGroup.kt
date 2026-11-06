package com.example.hello.ui.components.radio


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.semantics.Role
import androidx.compose.foundation.interaction.MutableInteractionSource
import com.example.hello.ui.theme.colors
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.scale

@Composable
fun AppRadioGroup(
    options: List<String>, //danh sách các lựa chọn
    selected: String,//lựa chọn hiện tại
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedColor: Color = colors.primary,
    unselectedColor: Color = colors.secondary,
    textColor: Color = colors.text,
    gap: Dp = 8.dp,
    radioScale: Float = 1f,//do lon cua radio
    onSelectedChange: (String) -> Unit,
) {
    Column(modifier = modifier.selectableGroup()) {

        options.forEach { option ->
            Row(
                modifier = Modifier

                   // .fillMaxWidth() // bỏ này ra thì wwidth của radio + text ngắn vừa đủ nên không nhan ngoài vùng trắng dc
                    .selectable(
                        selected = option == selected,
                        enabled = enabled,
                        role = Role.RadioButton,
                        onClick = { onSelectedChange(option) },
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                       indication = null // tắt nền xám khi nhấn
                    )
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(gap),
                verticalAlignment = Alignment.Top // chữ nằm giữa theo chiều dọc với nút

            )
            {
                RadioButton(
                    selected = option == selected,
                    onClick = null,
                    enabled = enabled,
                    modifier = Modifier.scale(radioScale),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = selectedColor,
                        unselectedColor = unselectedColor
                    )
                )
                Text(text = option, color = textColor)

            }
        }
    }

}