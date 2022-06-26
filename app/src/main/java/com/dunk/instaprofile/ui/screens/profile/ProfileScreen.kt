package com.dunk.instaprofile.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dunk.instaprofile.models.recentStories
import com.dunk.instaprofile.ui.theme.semiBoldStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import com.dunk.instaprofile.*
import com.dunk.instaprofile.R
import com.dunk.instaprofile.models.actions
import com.dunk.instaprofile.views.RoundImage

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        TopBar(name = "Account", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        ProfileDescription(
            displayName = "Jane Doe",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            profileUrl = "https://fmovies.wtf/search?keyword=state",
            followers = followingUsers
        )
        showActions(modifier = Modifier.padding(10.dp))
        RecentStories(modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        PostsTabView()
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notifications_24),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_view_headline_24),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(
                imageURL = profile_image, modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Stats(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun Stats(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        StatsItem(numberText = "601", title = "Posts")
        StatsItem(numberText = "99.8K", title = "Followers")
        StatsItem(numberText = "172", title = "Following")
    }
}

@Composable
fun StatsItem(
    numberText: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontWeight = FontWeight.Normal, fontSize = 12.sp)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    profileUrl: String,
    followers: Followers,
    modifier: Modifier = Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            style = TextStyle(fontSize = 13.sp)
        )
        Text(
            text = profileUrl,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            style = TextStyle(fontSize = 11.sp)
        )
        if (!followers.users.isNullOrEmpty()) {
            DisplayFollowers(followers.users)
        }
    }

}

@Composable
fun DisplayFollowers(users: List<Users>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        var usersNames: String? = null
        for (i in 0..2) {
            RoundImage(imageURL = users[i].profileImage, modifier = Modifier.size(30.dp))
            if (i <= 1) {
                usersNames = if (usersNames.isNullOrEmpty()) {
                    users[i].name
                } else {
                    usersNames.plus(",".plus(users[i].name))
                }
            }
        }
        usersNames?.let {
            Text(
                text = buildAnnotatedString {
                    append("Followed by ")
                    pushStyle(semiBoldStyle)
                    append(it)
                    pop()
                    append(" and ")
                    pushStyle(semiBoldStyle)
                    append("${users.size - 2}")
                    pop()
                    append(" others")
                },
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun showActions(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        items(actions) { action ->
            ProfileActions(name = action.name, iconDrawable = action.iconDrawableReference)
        }
    }
}

@Composable
fun ProfileActions(
    name: String?,
    iconDrawable: Int?,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {},
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .sizeIn(minHeight = 25.dp)
        ) {
            name?.let {
                Text(text = name, style = TextStyle(color = Color.Black))
                Spacer(Modifier.width(5.dp))
            }
            iconDrawable?.let {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = iconDrawable),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun RecentStories(
    modifier: Modifier = Modifier
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        items(recentStories) { staory ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoundImage(imageURL = staory.highLightUrl, modifier = modifier.size(65.dp))
                Text(text = staory.title, color = Color.Black, style = TextStyle(fontSize = 13.sp))
            }
        }
    }
}





















