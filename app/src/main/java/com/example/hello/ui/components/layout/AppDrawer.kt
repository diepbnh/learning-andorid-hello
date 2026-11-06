package com.example.hello.ui.components.layout


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hello.ui.theme.colors
import kotlinx.coroutines.launch


data class MenuItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
)

private val menuItems = listOf(
    MenuItem("Menu", "menu", Icons.Default.Menu),
    MenuItem("Profile", "profile", Icons.Default.Person),
    MenuItem("Card", "card", Icons.Default.Settings),
    MenuItem("Card 2", "card2", Icons.Default.Settings),
    MenuItem("Template", "template", Icons.Default.Settings),
    MenuItem("Table", "table", Icons.Default.Settings),
    MenuItem("Radio", "radio", Icons.Default.Settings),
    MenuItem("Checkbox", "checkbox", Icons.Default.Settings),
    MenuItem("Dialog", "dialog", Icons.Default.Settings),

    )

@Composable
fun AppDrawer(
    navController: NavController,
    drawerState: DrawerState, //menu đóng hay mở
    currentRoute: String, //đường dẫn hiện tại
    content: @Composable () -> Unit, //content chính
) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = colors.backgroundDialog,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colors.backgroundCard,
                modifier = Modifier.width(300.dp)
            ) {
                //header
                DrawerHeader()
                //drawer content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())//scroll y
                ) {
                    menuItems.forEach { item ->
                        //drawer item
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item.label,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 18.sp,
                                    //modifier = Modifier.offset(x = (-4).dp)
                                )
                            },
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .size(26.dp) // mặc định là 24dp
                                )
                            },
                            selected = item.route == currentRoute,//đường dẫn hiện tại
                            onClick = {
                                scope.launch { drawerState.close() }
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route)
                                }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
//set mau item
                                selectedContainerColor = colors.primary,
                                selectedTextColor = colors.white,
                                selectedIconColor = colors.white,

                                unselectedContainerColor = colors.white,
                                unselectedTextColor = colors.text,
                                unselectedIconColor = colors.text,
                            ),
                            shape = RoundedCornerShape(1.dp),
                            //vậy thi modifier = Modifier.padding(horizontal = 24.dp)
                        )

                    }
                }
                //drawer footer
                DrawerFooter()

            }


        },
        content = content

    )

}

@Composable
private fun DrawerHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            imageVector = Icons.Default.Home,
            contentDescription = "Logo",
            modifier = Modifier.size(40.dp)

        )

    }
    HorizontalDivider(color = colors.light)
}

@Composable
private fun DrawerFooter() {
    Text(
        text = "Version 1.0",
        fontSize = 12.sp,
        color = colors.secondary,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding( 24.dp, 16.dp, 24.dp, 5.dp)
    )
}