package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
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
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.unit.offset
import com.example.hello.ui.components.animation.AppGrassButterfly
import com.example.hello.ui.theme.boxShadow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {

    AppPage(
        modifier = modifier,
        scrollable = true,
        topBar = {

            CenterAlignedTopAppBar(  // androidx.compose.material3
                modifier = Modifier.boxShadow(
                    color = colors.black.copy(alpha = 0.15f),
                    y = 6.dp,
                    blur = 8.dp
                ),
                windowInsets = TopAppBarDefaults.windowInsets.add(
                    WindowInsets(left = 5.dp, right = 5.dp)
                ),
                title = { Text(text = "Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next"
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.primary.copy(alpha = 0.95f),
                    titleContentColor = colors.white,
                    navigationIconContentColor = colors.white,
                    actionIconContentColor = colors.white
                )


            )
        },


        )


    {


        //banner <div> bao ảnh lại
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
            style = titleMedium,//style font weight đã định nghĩa sẵn
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
            modifier = Modifier.align(Alignment.CenterHorizontally) //căn giữa
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    //.background(colors.secondary)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

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
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

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
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

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
                append("Xin chào ! \nMình là ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hồng Điệp")
                }
                append(" Mình đang học lập trình Android với Jetpack Compose")

                append(
                    ". Mục tiêu cuối là dựng được giao diện người dùng trên thiết bị di động. " +
                            "Nhiêu đó thôi cũng đã đủ mệt roài.......ahihi..."
                )
            },

            )
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.weight(1f)) // khoản cách đẩy xuôống margin-top: auto
        //component grass butterfly
        AppGrassButterfly()

    }
}
