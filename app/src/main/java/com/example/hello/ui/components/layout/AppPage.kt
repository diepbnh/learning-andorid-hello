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
//layout shared padding for all pages
fun AppPage(
    modifier: Modifier = Modifier,
    scrollable: Boolean=true,
    contentPadding: PaddingValues= PaddingValues(
        start = 24.dp,
        top = 28.dp,
        end = 24.dp,
        bottom = 24.dp
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
        contentWindowInsets = WindowInsets.safeDrawing, //avoid notch + keyboard
    ) {  innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if(scrollable)
                        Modifier.verticalScroll(rememberScrollState())
                    else
                        Modifier
                )
                .padding(innerPadding)
                .padding(contentPadding)
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment=horizontalAlignment
        )
        {
            content()
        }

    }
}