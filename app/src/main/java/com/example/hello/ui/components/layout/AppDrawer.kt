package com.example.hello.ui.components.layout


import androidx.compose.ui.graphics.Color
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hello.R
import com.example.hello.ui.theme.colors
import kotlinx.coroutines.launch


data class MenuItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
    val isDanger: Boolean = false,//mặc định là false
)

private val menuItems = listOf(
    MenuItem("Menu", "menu", Icons.Default.Menu),
    MenuItem("Profile", "profile", Icons.Default.Person),
    MenuItem("Card", "card", Icons.Default.Settings),
    MenuItem("Card 2", "card2", Icons.Default.Settings),
    MenuItem("Template", "template", Icons.Default.Settings),
    MenuItem("Table", "table", Icons.Default.DateRange),
    MenuItem("Radio", "radio", Icons.Default.Check),
    MenuItem("Checkbox", "checkbox", Icons.Default.CheckCircle),
    MenuItem("Dialog", "dialog", Icons.Default.Warning),
    MenuItem("Logout", "login", Icons.Default.Lock, isDanger = true),

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
                drawerContainerColor = colors.danger,
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
                        val itemColor =if (item.isDanger) colors.danger else colors.text
                        //drawer item
                        NavigationDrawerItem( // mặc định của drawer là full 100% nên khi nhấn thì vùng ngoài text vẫn bấm được
                           //Nếu bạn vẫn muốn chỉ bấm vào icon và chữ thì cũng làm
                            //  được, nhưng phải bỏ NavigationDrawerItem và tự viết
                            //  một Row riêng. Mình không khuyên làm vậy, vì sẽ khó
                            //  dùng hơn
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

                               unselectedContainerColor = Color.Transparent,
                                unselectedTextColor = itemColor,
                                unselectedIconColor = itemColor,
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
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(R.drawable.logo), //logo
            contentDescription = "Logo",
           // colorFilter = ColorFilter.tint(colors.danger),
            modifier = Modifier.size(106.dp,30.dp)

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