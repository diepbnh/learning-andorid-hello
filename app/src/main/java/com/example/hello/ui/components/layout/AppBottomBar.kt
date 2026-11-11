package com.example.hello.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.boxShadow
import com.example.hello.ui.theme.colors

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit //pages add whatever they need

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .boxShadow(
                color = colors.light,
                x = 0.dp,
                y = 0.dp,
                blur = 20.dp,
                spread = 0.dp
            )
            .background(colors.backgroundBody)
            .navigationBarsPadding()// bottom bar area
            .padding(horizontal = 24.dp, vertical = 16.dp),
        content = content
    )
}