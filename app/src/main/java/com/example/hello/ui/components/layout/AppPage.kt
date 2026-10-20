package com.example.hello.ui.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
//layout dùng chung padding cho all page
fun AppPage(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues= PaddingValues(
        start = 20.dp,
        top = 40.dp,
        end = 20.dp,
        bottom = 20.dp
    ),//padding common 20px
    horizontalAlignment: Alignment.Horizontal=Alignment.Start,
    topBar: @Composable () -> Unit = {},// top bar
    bottomBar: @Composable () -> Unit = {},// bottom bar
    content: @Composable ColumnScope.() -> Unit,//content pages
  )

{
    Scaffold(
        modifier=modifier,
        containerColor = Color.Transparent,
        topBar = topBar,
        bottomBar = bottomBar,
        contentWindowInsets = WindowInsets.safeDrawing, //tránh tai thỏ + bàn phím
    ) {  innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(contentPadding)
            .verticalScroll(rememberScrollState()) , //trang dài thì cuộn
            verticalArrangement = Arrangement.Top,
            horizontalAlignment=horizontalAlignment
        )
        {
            content()
        }

    }
}