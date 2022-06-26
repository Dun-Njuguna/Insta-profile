package com.dunk.instaprofile.ui.screens.profile.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dunk.instaprofile.models.userPosts

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Posts(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale( 1.01f)
    ){
        items(userPosts.size) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(userPosts[it].image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}