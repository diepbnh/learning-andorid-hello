package com.example.hello.ui.components.checkbox


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.colors
import androidx.compose.ui.graphics.Color
@Composable
fun AppCustomCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)? = null,
    label: String = "",
    textColor: Color = colors.text,
    size: Dp = 24.dp,
    gap: Dp = 8.dp,
) {
    val shape = RoundedCornerShape(6.dp)

    val toggleModifier = if (onCheckedChange != null) {
        Modifier.toggleable(
            value = checked,
            role = Role.Checkbox,
            onValueChange = onCheckedChange,
            interactionSource = remember { MutableInteractionSource() },
            indication = null//no gray ripple when tapping
        )
    } else {
        Modifier
    }
    Row(
        modifier = modifier.then(toggleModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(gap)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(shape)
                .background(if (checked) colors.primary else colors.white)
                .border(2.dp, colors.primary, shape),
            contentAlignment = Alignment.Center

        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = colors.white,
                    modifier = Modifier.size(size * 0.7f)
                )
            }
        }
        if (label.isNotEmpty()) {
            Text(text = label, color = textColor)
        }
    }

}