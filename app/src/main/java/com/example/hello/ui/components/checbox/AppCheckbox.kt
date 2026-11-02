package com.example.hello.ui.components.checbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import com.example.hello.ui.theme.colors
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.CornerRadius

@Composable
fun AppCheckbox(
    label: String,//text ben canh
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,//báo cho trang biết giá trị mới
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    checkMarkColor: Color = colors.white,
    checkedColor: Color = colors.primary,
    uncheckedColor: Color = colors.primary,
    textColor: Color = colors.text,
    gap: Dp = 8.dp,

) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
//            .toggleable( //tap vào text để checked
//                value = checked,
//                enabled = enabled,
//                role = Role.Checkbox,
//                onValueChange = onCheckedChange
//
//            ),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(gap)//khoản cách giữa các phần tử
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                enabled = enabled,
                colors = CheckboxDefaults.colors(
                    checkedColor = checkedColor,
                    uncheckedColor = uncheckedColor,
                    checkmarkColor = checkMarkColor
                )
            )
            Text(
                text = label, color = textColor
            )

        }
    }

}