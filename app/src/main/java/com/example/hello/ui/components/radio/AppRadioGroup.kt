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
    options: List<String>, //list of options
    selected: String,//current selection
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedColor: Color = colors.primary,
    unselectedColor: Color = colors.secondary,
    textColor: Color = colors.text,
    gap: Dp = 8.dp,
    radioScale: Float = 1f,//radio size
    onSelectedChange: (String) -> Unit,
) {
    Column(modifier = modifier.selectableGroup()) {

        options.forEach { option ->
            Row(
                modifier = Modifier

                   // .fillMaxWidth() // without this, width fits radio + text, so taps on empty space are ignored
                    .selectable(
                        selected = option == selected,
                        enabled = enabled,
                        role = Role.RadioButton,
                        onClick = { onSelectedChange(option) },
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                       indication = null // disable gray ripple on press
                    )
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(gap),
                verticalAlignment = Alignment.Top // text vertically aligned with the button

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