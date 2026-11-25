package com.example.hello.ui.components.dropdown

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import com.example.hello.ui.components.radio.AppRadio
import com.example.hello.ui.theme.colors


// Popup always placed at the top-left of the window



//1. Shared field: rounded box + text + rotating arrow

@Composable
fun DropdownField(
    text: String,
    placeholder: String,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onBoundsChange: (Rect) -> Unit = {},   // tell the parent where the field is on screen
) {
    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = "arrowRotation"
    )
    Row(
        modifier = modifier
            .padding(vertical = 6.dp)
            .onGloballyPositioned { coords ->                              // visible field area
                val topLeft = coords.localToScreen(Offset.Zero)           // position on SCREEN (px)
                onBoundsChange(Rect(topLeft, coords.size.toSize()))
            }
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(colors.backgroundTextField)
            .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text.ifEmpty { placeholder },
            color = colors.text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = placeholder,
            tint = colors.primary,
            modifier = Modifier
                .size(34.dp)
                .rotate(arrowRotation)
        )
    }

}

//2. Single-select dropdown
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AppDropdown(
    options: List<String>,
    selected: String, //selected item
    onSelectedChange: (String) -> Unit, //callback when selected item changes
    modifier: Modifier = Modifier,
    placeholder: String = "Select an option",
    showDivider: Boolean = true,
    showRadio: Boolean = false,
    leadingContent: (@Composable (String) -> Unit)? = null, //image/icon on the left
    showScrim: Boolean = false,
) {
    var expanded by remember { mutableStateOf(false) }
    var fieldBounds by remember { mutableStateOf(Rect.Zero) } // field position on screen (px)

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier

    ) {
        //the field
        DropdownField(
            text = selected,
            placeholder = placeholder,
            expanded = expanded,
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable),
            onBoundsChange = { fieldBounds = it }
        )

        if (showScrim && expanded) {
            DropdownScrim(
                hole = fieldBounds,                 // keep the field bright
                onDismiss = { expanded = false }
            )
        }

        //The menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = colors.backgroundTextField,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .heightIn(max = 260.dp)
                .layout { measurable, constraints ->
                    val cut = 8.dp.roundToPx()
                    val placeable = measurable.measure(constraints)
                    layout(
                        placeable.width, (placeable.height -
                                cut * 2).coerceAtLeast(0)
                    ) { // report 16dp shorter
                        placeable.place(0, -cut)
                    }
                }
            //end edit

        ) {
            options.forEachIndexed { index, option ->
                val isSelected = selected == option
                val highlight = isSelected && !showRadio

                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            color = if (highlight) colors.white else colors.text
                        )

                    },

                    //2 lefty slot
                    leadingIcon = leadingContent?.let { content ->

                        { content(option) }

                    },

                    //3 right slot
                    trailingIcon = if (showRadio) {
                        { AppRadio(selected = isSelected) }
                    } else null,
                    contentPadding =
                        PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    modifier = Modifier.background(
                        if (highlight) colors.primary
                        else Color.Transparent
                    ),
                    onClick = {
                        onSelectedChange(option)
                        expanded = false // single  select: close after choosing

                    }
                )
                //1 devider

                if (showDivider && index < options.lastIndex) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = colors.light
                    )
                }

            }

        }
    }
}
// Always place the popup at the top-left corner of the screen
private object FullScreenPosition : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset = IntOffset.Zero
}

// Dark backdrop behind the dropdown menu (covers status bar + navigation bar too).
// `hole` = area that stays bright (the field), in screen pixels.
@Composable
internal fun DropdownScrim(hole: Rect, onDismiss: () -> Unit) {
    val scrimColor = colors.backgroundDialog
    var scrimOrigin by remember { mutableStateOf(Offset.Zero) } // where the scrim starts on screen
    val density = LocalDensity.current
    val topInset = WindowInsets.statusBars.getTop(density)        // status bar height (px)
    val bottomInset = WindowInsets.navigationBars.getBottom(density) // navigation bar height (px)
    val screenSize = LocalWindowInfo.current.containerSize        // full screen size (px)

    Popup(
        popupPositionProvider = FullScreenPosition,
        onDismissRequest = onDismiss,
        properties = PopupProperties(clippingEnabled = false)     // allow drawing over system bars
    ) {
        Box(
            modifier = Modifier
                .requiredSize(
                    width = with(density) { screenSize.width.toDp() },
                    height = with(density) { (screenSize.height + topInset + bottomInset).toDp() }
                )
                .onGloballyPositioned { scrimOrigin = it.localToScreen(Offset.Zero) }
                .drawBehind {
                    // Convert the hole from screen position to scrim position
                    val localHole = hole.translate(-scrimOrigin)
                    // Pill-shaped hole, same shape as the field
                    val holePath = Path().apply {
                        addRoundRect(RoundRect(localHole, CornerRadius(localHole.height / 2)))
                    }
                    // Paint dark everywhere EXCEPT inside the hole
                    clipPath(holePath, clipOp = ClipOp.Difference) {
                        drawRect(scrimColor)
                    }
                }
        )
    }
}