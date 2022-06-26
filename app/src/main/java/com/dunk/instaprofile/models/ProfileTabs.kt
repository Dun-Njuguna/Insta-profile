package com.dunk.instaprofile.models

import com.dunk.instaprofile.*

data class ProfileTabs(
    val name: String,
    val icon:Int,
    val description:String? = null,
    val type:Int
)

val tabs = listOf(
    ProfileTabs(name = "Posts", icon = R.drawable.ic_baseline_posts_module_24, type = posts),
    ProfileTabs(name = "Reels", icon = R.drawable.ic_baseline_reels_24, type = reels),
    ProfileTabs(name = "Series", icon = R.drawable.ic_baseline_play_series_24, type = series),
    ProfileTabs(name = "Tagged", icon = R.drawable.ic_baseline_tagged_24, type = tagged)
)