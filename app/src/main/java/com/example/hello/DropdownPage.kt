package com.example.hello

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import com.example.hello.ui.components.layout.AppNavBar
import com.example.hello.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownPage(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)//menu open or closed
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "dropdown"
    ) {
        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Dropdown",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                AppNavBar(
                    navController = navController,
                    currentRoute = "dropdown"
                )
            }
        ) {

            var city by remember { mutableStateOf("") }
            var cityExpanded by remember { mutableStateOf(false) }
            val arrowRotation by animateFloatAsState(
                targetValue = if (cityExpanded) 180f else 0f,
                label = "arrowRotation"
            )
            val cities =
                listOf("Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Cần Thơ", "Trà Vinh", "Ben Tre")
            val shape = RoundedCornerShape(32.dp)

            ExposedDropdownMenuBox(
                expanded = cityExpanded,
                onExpandedChange = { cityExpanded = it },
            ) {
                Row(
                    modifier = Modifier
                        .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                        .fillMaxWidth()
                        .padding(bottom = 6.dp) //margin bottom
                        .height(48.dp)
                        .clip(shape)
                        .background(colors.backgroundTextField)
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (city.isEmpty()) "Select city" else city,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Select city",
                        tint = colors.primary,
                        modifier = Modifier
                            .size(34.dp)
                            .rotate(arrowRotation)
                    )

                }
                ExposedDropdownMenu(
                    expanded = cityExpanded,
                    onDismissRequest = { cityExpanded = false },
                    containerColor = colors.backgroundTextField, //background of dropdown
                    shape = RoundedCornerShape(16.dp),
                    // edit first item and last item same height 48px
                    modifier = Modifier
                        .heightIn(max = 260.dp)//height of dropdown
                        .layout { measurable, constraints ->
                            val cut = 8.dp.roundToPx()
                            val placeable = measurable.measure(constraints)
                            layout(
                                placeable.width, (placeable.height -
                                        cut * 2).coerceAtLeast(0)
                            ) { // report 16dp shorter
                                placeable.place(0, -cut)
                            }
                        }
                    //end edit
                ) {
                    cities.forEachIndexed { index, option ->
                        val isSelectedItem = city == option //item is selected when text == option
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    color = if (isSelectedItem) colors.white else colors.text
                                )

                            },
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                            modifier = Modifier
                                .background(
                                    if (isSelectedItem) colors.primary else Color.Transparent
                                ),
                            onClick = {
                                city = option // save the selected option
                                cityExpanded = false //close the list
                            }

                        )
                        if (index < cities.lastIndex) {
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = colors.light
                            )

                        }
                    }
                }
            }

            Text("Teeeeeeeeeeeeeeeeeeeeext")
            Text("")
            StaticDropdown()
        }
    }
}

//status dropdown
@Composable
fun StaticDropdown() {
    val fieldShape = RoundedCornerShape(32.dp)
    val menuShape = RoundedCornerShape(16.dp)
    Column {
        //1. The filed
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp) //margin bottom)
                .height(48.dp)
                .clip(fieldShape)
                .background(colors.backgroundTextField)
                .padding(start = 16.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "Select city",
                modifier = Modifier
                    .weight(1f)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Select city",
                tint = colors.primary,
                modifier = Modifier
                    .size(34.dp)
                    .rotate(180f)
            )
        }
        //2. The menu box
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(3.dp,menuShape)
                .background(colors.backgroundTextField)
        ) {
            // Item 1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Item 1")

            }
            HorizontalDivider(thickness = 1.dp, color = colors.light)
            //Item 2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Item 2")

            }
            HorizontalDivider(thickness = 1.dp, color = colors.light)
        }
    }
}
