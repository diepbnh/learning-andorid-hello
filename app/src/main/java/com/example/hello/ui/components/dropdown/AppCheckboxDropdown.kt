package com.example.hello.ui.components.dropdown

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import com.example.hello.ui.components.checkbox.AppCustomCheckbox
import com.example.hello.ui.theme.colors
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCheckboxDropdown(
    options: List<String>,
    selected: Set<String>,
    onSelectedChange: (Set<String>) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Select options",
    showDivider: Boolean = true,
    leadingContent: (@Composable (String) -> Unit)? =
        null, // type 2: image/icon on the left
    showScrim: Boolean = false,
) {
    var expanded by remember { mutableStateOf(false) }
    var fieldBounds by remember { mutableStateOf(Rect.Zero) } // field position on screen
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier
    ) {
        // Reuse the same field as AppDropdown
        DropdownField(
            text = selected.joinToString(", "),     //

                    placeholder = placeholder,
            expanded = expanded,
            modifier = Modifier.menuAnchor(
                ExposedDropdownMenuAnchorType.PrimaryNotEditable
            ),
            onBoundsChange = { fieldBounds = it }
        )
        if (showScrim && expanded) {
            DropdownScrim(
                hole = fieldBounds,                 // keep the field bright
                onDismiss = { expanded = false }
            )
        }
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = colors.backgroundTextField,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .heightIn(max = 260.dp)

                .layout { measurable, constraints ->
                    val cut = 8.dp.roundToPx()
                    val placeable =
                        measurable.measure(constraints)
                    layout(
                        placeable.width,
                        (placeable.height - cut * 2).coerceAtLeast(0)
                    ) {
                        placeable.place(0, -cut)
                    }
                }
        ) {
            options.forEachIndexed { index, option ->
                val isChecked = option in selected

                DropdownMenuItem(
                    text = {
                        Text(
                            text = option, color
                            = colors.text
                        )
                    },
                    leadingIcon = leadingContent?.let { content ->
                        { content(option) }
                    },
                    trailingIcon = {
                        AppCustomCheckbox(checked = isChecked)
                    },
                    contentPadding =
                        PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    onClick = {
                        onSelectedChange(
                            if (isChecked) selected -
                                    option else selected + option
                        )
                    }
                )

                if (showDivider && index <
                    options.lastIndex
                ) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = colors.light
                    )
                }
            }
        }
    }
}
