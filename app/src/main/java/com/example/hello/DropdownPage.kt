package com.example.hello

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import com.example.hello.ui.components.dropdown.AppCheckboxDropdown
import com.example.hello.ui.components.dropdown.AppDropdown
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
                        text = city.ifEmpty { "Select city" },
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

            Text("")
            Text("Dropdown normal:")
            Spacer(modifier = Modifier.height(10.dp))

            ComponentDropdown1()
            Spacer(modifier = Modifier.height(15.dp))
            Text("Dropdown Radio:")

            Spacer(modifier = Modifier.height(10.dp))
            ComponentDropdown2()
            Spacer(modifier = Modifier.height(15.dp))

            Text("Dropdown checkbox:")
            Spacer(modifier = Modifier.height(10.dp))
            ComponentDropdown3()
            Spacer(modifier = Modifier.height(15.dp))

            Text("Dropdown checkbox and images:")
            Spacer(modifier = Modifier.height(10.dp))
            ComponentDropdownImages()
            Spacer(modifier = Modifier.height(15.dp))

            Text("Dropdown images:")
            Spacer(modifier = Modifier.height(10.dp))
            ComponentDropdown4()
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}


@Composable
fun ComponentDropdown1() {
    var city by remember { mutableStateOf("") }

    val cities = listOf(
        "Hà Nội", "Hồ Chí Minh", "Đà Nẵng",
        "Cần Thơ", "Trà Vinh", "Bến Tre"
    )

    Column {
        AppDropdown(
            options = cities,
            selected = city,
            onSelectedChange = { city = it },
            placeholder = "Select city"
        )
    }

}

@Composable
fun ComponentDropdown2() {
    var size by remember { mutableStateOf("") }
    val sizes = listOf("Small", "Medium", "Large")

    Column {
        AppDropdown(
            options = sizes,
            selected = size,
            onSelectedChange = { size = it },
            placeholder = "Select size",
            showRadio = true ,//show radio
           showScrim = true
        )
    }

}

@Composable
fun ComponentDropdown3() {
    var amenities by remember {
        mutableStateOf(setOf<String>())
    }
    val options = listOf("Wifi", "Parking", "Pool","Gym", "Breakfast")

    AppCheckboxDropdown(
        options = options,
        selected = amenities,
        onSelectedChange = { amenities = it },
        placeholder = "Select amenities",
        showScrim = true
    )

}


@Composable
fun ComponentDropdownImages() {
    var cars by remember {
        mutableStateOf(setOf<String>()) }
    val carImages = mapOf(
        "ToyotaToyotaToyotaToyotaToyotaToyotaToyota yuuuuuu yuuuuuu yuuuuuu yuuuuuu " to R.drawable.car01,
        "Honda" to R.drawable.car02,
        "BMW" to R.drawable.car03,
    )
    AppCheckboxDropdown(
        options = carImages.keys.toList(),
        selected = cars,
        onSelectedChange = { cars = it },
        placeholder = "Select cars",
        leadingContent = {option ->
            Image(
                painter = painterResource(carImages.getValue(option)),
                contentDescription = option,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
        }

    )
}

@Composable
fun ComponentDropdown4() {
    var car by remember { mutableStateOf("") }
    val carImages = mapOf(
        "Toyota" to R.drawable.car01,
        "Honda" to R.drawable.car02,
        "Ford" to R.drawable.car03,
        "BMW" to R.drawable.car04)

    AppDropdown(
        options = carImages.keys.toList(),
        selected = car,
        onSelectedChange = { car = it },
        placeholder = "Select car",
        leadingContent = { option ->
            Image(
                painter = painterResource(carImages.getValue(option)),
                contentDescription = option,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
        }
    )
}
