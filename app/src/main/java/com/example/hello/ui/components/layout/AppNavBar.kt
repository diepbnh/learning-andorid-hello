package com.example.hello.ui.components.layout


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hello.ui.theme.boxShadow
import com.example.hello.ui.theme.colors

//1. data class holding one menu item
data class AppNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
)

//2 item nav
private val navItems = listOf(
    AppNavItem("Home", "home", Icons.Default.Home),
    AppNavItem("Card", "card", Icons.Default.AccountBox),
    AppNavItem("Drop", "dropdown", Icons.Default.DateRange),
    AppNavItem("Setting", "checkbox", Icons.Default.Settings),
)

//3. shared tab bar
@Composable
fun AppNavBar(
    navController: NavController,
    currentRoute: String,//current route
    hasShadow: Boolean = true,//default
    buttonSize: Dp = 70.dp,
) {
    val barShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .boxShadow(
                color = colors.black.copy(alpha = 0.1f),
                y = (-4).dp,
                blur = 15.dp,
                shape = barShape
            )
            .background(colors.white, barShape)
            .navigationBarsPadding() // leave room for system nav bar
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,//spacing between buttons
    ) {
        navItems.forEach { item ->
            AppNavBarButton(
                item = item,
                selected = currentRoute == item.route,
                hasShadow = hasShadow,
                buttonSize = buttonSize,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo("home") {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true

                        }
                    }
                }
            )
        }
    }
}

//4. Button + icon + text
@Composable
private fun AppNavBarButton(
    item: AppNavItem,
    selected: Boolean,
    hasShadow: Boolean,
    buttonSize: Dp,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(16.dp)
    val bg = if (selected) colors.primary else colors.white
    val contentColor = if (selected) colors.white else colors.primary

    Column(
        modifier = Modifier
            .size(buttonSize)
            .then(
                if (hasShadow && !selected)
                    Modifier.boxShadow(
                        color = colors.black.copy(alpha = 0.2f),
                        y = 4.dp,
                        blur = 8.dp,
                        shape = shape
                    )
                else Modifier
            )
            .background(bg,shape)
            .clip(shape)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            tint = contentColor,
            modifier = Modifier.size(26.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = item.label,
            color = contentColor,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

