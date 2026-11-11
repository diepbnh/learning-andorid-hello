package com.example.hello

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.components.card.AppCard
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppNavBar
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar
import com.example.hello.ui.theme.titleMedium
import kotlinx.coroutines.launch

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)//menu open or closed
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "home"
    ) {
        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Home",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }    ,
            bottomBar = {
                AppNavBar(
                    navController = navController,
                    currentRoute = "home"
                )
            }

        ) {
            //content here
            ListBox()
            Spacer(modifier = Modifier.height(15.dp))

        }
    }
}

@Composable
private fun ListBox() {

    AppCard(
        hasShadow = true,
    ) {
        Text(
            text = "Smith Family",
            style = titleMedium

        )
        Text("Dad · 12 min ago · Near Irvine, CA")
    }
    Spacer(modifier = Modifier.height(15.dp))
    AppCard(
        hasShadow = true,
    ) {
        Text(
            text = "Smith Family",
            style = titleMedium

        )
        Text("Dad · 12 min ago · Near Irvine, CA")
    }

}

