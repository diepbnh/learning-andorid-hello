package com.example.hello.ui.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.hello.ui.theme.AppColors
import com.example.hello.ui.theme.colors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.SolidColor

fun appTextFieldBorderColor(
    isError: Boolean,
    isFocused: Boolean,
    colors: AppColors,
): Color = when {
    isError -> colors.danger
    isFocused -> colors.primary
    else -> colors.light
}

@Composable
fun AppTextField(
    modifier: Modifier=Modifier,
    value:String = "",
    onValueChange:(String)->Unit,
    placeholder: String ="",
    isError:Boolean=false,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
){
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val textStyle = MaterialTheme.typography.bodyLarge.copy(color = colors.text)

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        visualTransformation = visualTransformation,
        singleLine = true,
        textStyle = textStyle,
        cursorBrush = SolidColor(colors.primary),
        interactionSource = interactionSource,
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = appTextFieldBorderColor(isError, isFocused, colors),
                shape = RoundedCornerShape(30.dp)
            ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) { //nếu giá trị input rỗng thì hiển thị text trong placeholder
                    Text(
                        text = placeholder,
                        fontSize = 13.sp,//set cho text placeholder
                        color = colors.text.copy(alpha = 0.5f)//màu text placeholder
                    )
                }

                innerTextField()
            }
        }
    )

}