package com.dunk.instaprofile.models

import com.dunk.instaprofile.*

data class ProfileActions(
    val type:Int,
    val name:String?,
    val iconDrawableReference: Int?
)

val actions = listOf(
    ProfileActions(type = view_following_actions, name = "Following", iconDrawableReference = R.drawable.ic_baseline_arrow_down_24),
    ProfileActions(type = message, name = "Message", iconDrawableReference = null),
    ProfileActions(type = contact, name = "Contact", iconDrawableReference = null),
    ProfileActions(type = similar, name = null, iconDrawableReference = R.drawable.ic_baseline_person_add_24)
)