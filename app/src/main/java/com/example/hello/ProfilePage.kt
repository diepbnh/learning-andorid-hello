package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.hello.ui.components.avatar.AppAvatar
import com.example.hello.ui.theme.titleMedium
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.hello.ui.components.animation.AppGrassButterfly
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppTopBar
import kotlinx.coroutines.launch

@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)//menu open or closed
    val scope = rememberCoroutineScope() // open
    AppDrawer(
        navController = navController,
        drawerState=drawerState,
        currentRoute = "profile"
    )
    {

        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Profile",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate("home") }) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        }
                    }
                )
            },


            )


        {


            //banner <div> wrapping the image
            Box(
                modifier = Modifier
//                .layout { measurable, constraints ->
//                    val bleed = 24.dp.roundToPx()
//                    val placeable = measurable.measure(constraints.offset(horizontal = bleed * 2))
//                    layout(constraints.maxWidth, placeable.height) {
//                        placeable.placeRelative(-bleed, 0)
//                    }
//                }
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.banner),
                    contentDescription = "Cover Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            //hongdiep
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Hong Diep",
                style = titleMedium,//predefined font weight style
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Frontend Developer",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            //component avatar
            AppAvatar(
                imageRes = R.drawable.diep,
                borderWidth = 3.dp,
                borderColor = colors.white,
                shadowElevation = 20.dp,
                modifier = Modifier.align(Alignment.CenterHorizontally) //center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                //home column
                Column(
                    modifier = Modifier
                        .weight(2f)
                        //.background(colors.secondary)
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally//center all children

                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = colors.primary,
                        // modifier = Modifier.align(Alignment.CenterHorizontally)

                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Home",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                //home column
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally//center all children

                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = colors.danger,
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Favorite",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                //home column
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally//center all children

                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = colors.primary,
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Profile",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            //end row
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Hello! \nI'm ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Hong Diep")
                    }
                    append(" I'm learning Android programming with Jetpack Compose")

                    append(
                        ". The end goal is to build user interfaces on mobile devices. " +
                                "That alone is tiring enough.......hehe..."
                    )
                },

                )
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.weight(1f)) // spacer pushes down, like margin-top: auto
            //component grass butterfly
            AppGrassButterfly()

        }
    }
}
