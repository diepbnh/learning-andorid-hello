package com.example.hello.ui.components.toggle

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.colors
import androidx.compose.ui.Alignment
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults


@Composable
fun AppSwitch(
    modifier: Modifier = Modifier,
    label: String = "",//chữ bên trái
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    checkedThumbColor: Color = colors.white,//màu thumb
    checkedTrackColor: Color = colors.primary,//màu nền
    uncheckedThumbColor: Color = colors.primary,//màu thumb
    uncheckedTrackColor: Color = colors.white,//màu không check
    gap: Dp = 6.dp,
    textColor: Color = colors.text,

    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .toggleable(
                value = checked,
                enabled = enabled,
                onValueChange = onCheckedChange,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(gap),//khoản cách text và toggle
        verticalAlignment = Alignment.CenterVertically // text middle
    ) {
        Text(
            text = label,
            color = textColor,
            modifier = Modifier.weight(1f)//đẩy Switch sang phải
        )
        Switch(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled,
            colors=SwitchDefaults.colors(
                checkedThumbColor = checkedThumbColor,
                checkedTrackColor = checkedTrackColor,
                uncheckedThumbColor = uncheckedThumbColor,
                uncheckedTrackColor = uncheckedTrackColor
            )
        )
    }


}