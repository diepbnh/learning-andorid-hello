package com.example.hello

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
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
import com.example.hello.ui.theme.colors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

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
            Text(text = "Featured cars", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Carousel1()
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "galleryState", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Carousel2()
        }
    }

}

@Composable
private fun Carousel1() {
    val cars = listOf(R.drawable.car01, R.drawable.car02, R.drawable.car03, R.drawable.car04)
    val pagerState = rememberPagerState(pageCount = { cars.size })//page
    LaunchedEffect(pagerState.settledPage) {
        delay(3.seconds)

        val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
        pagerState.animateScrollToPage(
            page = nextPage,
            animationSpec = tween(
                600,
                easing = FastOutSlowInEasing
            )

        )//scroll to next page
    }


    HorizontalPager(
        state = pagerState,
        pageSpacing = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))

    ) { page ->//page is index
        Image(
            painter = painterResource(cars[page]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }

    //pagination
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(
            6.dp,
            Alignment.CenterHorizontally
        ) // gap + center
    ) {
        repeat(pagerState.pageCount) { index ->
            val isCurrent = index == pagerState.currentPage
            Box(
                modifier = Modifier
                    .size(
                        width = if (isCurrent) 20.dp else 8.dp,
                        height = 8.dp
                    ) // current dot is longer
                    .background(if (isCurrent) colors.primary else colors.light, CircleShape)
            )
        }
    }
}

@Composable
private fun Carousel2() {
    val cars = listOf(R.drawable.car01, R.drawable.car02, R.drawable.car03, R.drawable.car04)
    val pagerState = rememberPagerState(pageCount = { cars.size })//page

    LaunchedEffect(pagerState.settledPage) {
        delay(3.seconds)
        val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
        pagerState.animateScrollToPage(
            page = nextPage,
            animationSpec = tween(
                600,
                easing = LinearOutSlowInEasing
            )

        )//scroll to next page
    }


    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        pageSpacing = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)

    ) { page ->//page is index
        Image(
            painter = painterResource(cars[page]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )
    }
}