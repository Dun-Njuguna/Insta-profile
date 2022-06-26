package com.dunk.instaprofile

data class Followers(
    val users: List<Users>
)

data class Users(
    val name: String,
    val profileImage: String
)

val followingUsers = Followers(
    users = listOf(
        Users(
            "user 1",
            "https://cdni.iconscout.com/illustration/free/thumb/standing-woman-1668003-1415675.png"
        ),
        Users(
            "user 2",
            "https://cdni.iconscout.com/illustration/free/thumb/standing-woman-1668003-1415675.png"
        ),
        Users(
            "user 3",
            "https://cdni.iconscout.com/illustration/free/thumb/standing-lady-1668008-1415672.png"
        ),
        Users(
            "user 4",
            "https://assets.website-files.com/5bff8886c3964a992e90d465/5c00fa3ad82b40e853c9952f_hero-3.svg"
        ),
        Users(
            "user 5",
            "https://assets.website-files.com/5bff8886c3964a992e90d465/5c00fa3ad82b40e853c9952f_hero-3.svg"
        ),
    )
)