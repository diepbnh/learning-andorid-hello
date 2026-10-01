package com.example.hello.ui.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hello.ui.theme.colors


@Composable
fun AppFormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorMessage:String="",
) {
    Column(modifier = modifier){
        // 1. Text hiển thị label (copy style từ SignUpPage)
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // 2. AppTextField: truyền value, onValueChange, placeholder,
        //    visualTransformation = if (isPassword) ... else ...
        AppTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = placeholder,
            isError = isError,
            visualTransformation =
                if (isPassword)
                    PasswordVisualTransformation() //hiển thị biểu tượng password
                else
                    VisualTransformation.None
        )
        if(isError && errorMessage.isNotEmpty())
        {
            Text(
                text=errorMessage,
                color=colors.danger,
                fontSize = 12.sp,
                modifier=Modifier.padding(start = 4.dp, top = 4.dp)
            )

        }

    }
}
