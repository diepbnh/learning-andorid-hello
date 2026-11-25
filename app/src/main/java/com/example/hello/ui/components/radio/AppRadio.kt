package com.example.hello.ui.components.radio

import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.colors

// A single radio circle: no label, no click by default
@Composable
fun AppRadio(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    selectedColor: Color = colors.primary,
    unselectedColor: Color = colors.secondary,
    radioScale: Float = 1f, //radio size
    ) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            modifier = modifier.scale(radioScale),
            colors = RadioButtonDefaults.colors(
                selectedColor = selectedColor,
                unselectedColor = unselectedColor
            )
        )
    }
}