package com.example.hello.ui.components.checkbox

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.hello.ui.theme.colors
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.Role

@Composable
fun AppCheckbox(
    modifier: Modifier = Modifier,
    label: String="",//text next to it
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,//tell the page the new value
    enabled: Boolean = true,
    checkMarkColor: Color = colors.white,
    checkedColor: Color = colors.primary,
    uncheckedColor: Color = colors.primary,
    textColor: Color = colors.text,
    gap: Dp = 8.dp,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .toggleable( //tap the text to check
                value = checked,
                enabled = enabled,
                role = Role.Checkbox,
                onValueChange = onCheckedChange,
                interactionSource = remember { MutableInteractionSource() },
                indication = null//disable gray ripple when tapping text

            ),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(gap)//spacing between items
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
            Checkbox(
                checked = checked,
                onCheckedChange = null,
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