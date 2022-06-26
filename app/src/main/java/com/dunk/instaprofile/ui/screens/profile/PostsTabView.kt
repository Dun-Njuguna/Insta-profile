package com.dunk.instaprofile.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.dunk.instaprofile.models.tabs
import com.dunk.instaprofile.posts
import com.dunk.instaprofile.reels
import com.dunk.instaprofile.series
import com.dunk.instaprofile.tagged
import com.dunk.instaprofile.ui.screens.profile.pages.Posts
import com.dunk.instaprofile.ui.screens.profile.pages.Reels
import com.dunk.instaprofile.ui.screens.profile.pages.Series
import com.dunk.instaprofile.ui.screens.profile.pages.Tagged
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostsTabView(
    modifier: Modifier = Modifier
) {
    val inactiveColor = Color(0xFF777777)
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
    ) {
        TabRow(
            selectedTabIndex =  pagerState.currentPage,
            backgroundColor = Color.Transparent
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selectedContentColor = Color.Black,
                    unselectedContentColor = inactiveColor,
                    selected = index == pagerState.currentPage,
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(index) }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = tabs[index].icon),
                            contentDescription = tabs[index].description
                        )
                    }
                )
            }
        }
        HorizontalPager(
            count = tabs.size,
            state = pagerState,
        ) { tabIndex ->
            when (tabIndex) {
                posts -> {
                    Posts()
                }
                reels ->{
                    Reels()
                }
                series -> {
                    Series()
                }
                tagged -> {
                    Tagged()
                }
                else -> {
                    Text("Coming soon")
                }
            }
        }

    }
}