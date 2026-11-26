package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppDrawer
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CarouselPage(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()//open
    AppDrawer(
        navController = navController,
        drawerState = drawerState,
        currentRoute = "carousel"
    ) {

        AppPage(
            modifier = modifier,
            scrollable = true,
            topBar = {
                AppTopBar(
                    title = "Carousel",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } })
                        {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) {

            val cars =listOf(R.drawable.car01, R.drawable.car02, R.drawable.car03, R.drawable.car04)
            val pagerState = rememberPagerState(pageCount = {cars.size})//page
            LaunchedEffect(pagerState.settledPage) {
                delay(3000)
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.animateScrollToPage(nextPage)//scroll to next page
            }

            Text(text = "Featured cars", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalPager(
                state = pagerState,
                pageSpacing = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))

            ){
                page ->//page is index
                Image(
                    painter = painterResource(cars[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}