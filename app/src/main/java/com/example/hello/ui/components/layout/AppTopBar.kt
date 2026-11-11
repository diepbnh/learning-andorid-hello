package com.example.hello.ui.components.layout


import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.boxShadow
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,//page title
    navigationIcon: @Composable () -> Unit = {},//left, empty by default
    actions: @Composable RowScope.() -> Unit = {} // right, empty by default
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.boxShadow(
            color = colors.black.copy(alpha = 0.15f),
            y = 6.dp,
            blur = 8.dp
        ),
        //padding left and right
        windowInsets = TopAppBarDefaults.windowInsets.add(
            WindowInsets(left = 5.dp, right = 5.dp)
        ),
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
                )
        },
        navigationIcon = navigationIcon,//left nav
        actions = actions,//right nav
        //header background color
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.primary.copy(alpha = 0.95f),
            titleContentColor = colors.white,
            navigationIconContentColor = colors.white,
            actionIconContentColor = colors.white
        )
    )
}