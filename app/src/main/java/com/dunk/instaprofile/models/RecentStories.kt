package com.dunk.instaprofile.models

data class RecentStories(
    val title: String,
    val highLightUrl: String,
)

val recentStories = arrayListOf (
    RecentStories(title = "Test 1", highLightUrl = "https://media.istockphoto.com/vectors/young-woman-listen-music-with-headphone-and-feel-joyful-vector-id1254764171?k=20&m=1254764171&s=612x612&w=0&h=STytmkIfajTCb_VqHubPq1veQXXcsEpXsfjoyN8RqgE="),
    RecentStories(title = "Test 2", highLightUrl = "https://cdn.dribbble.com/users/1068771/screenshots/14737460/media/981729384557d95f533270aac56a9603.jpg?compress=1&resize=400x300"),
    RecentStories(title = "Test 3", highLightUrl = "https://png.pngtree.com/png-clipart/20220307/original/pngtree-ramadan-illustration-muslim-children-reading-the-koran-png-image_7420819.png"),
    RecentStories(title = "Test 4", highLightUrl = "https://www.pixton.com/hs-fs/hubfs/Images/website%20pages/Educator%20Main%20Landing%20Page/NoBrainerAccess_512w.png?width=480&height=364&name=NoBrainerAccess_512w.png"),
    RecentStories(title = "Test 5", highLightUrl = "https://media.istockphoto.com/vectors/young-woman-listen-music-with-headphone-and-feel-joyful-vector-id1254764171?k=20&m=1254764171&s=612x612&w=0&h=STytmkIfajTCb_VqHubPq1veQXXcsEpXsfjoyN8RqgE="),
    RecentStories(title = "Test 6", highLightUrl = "https://media.istockphoto.com/vectors/young-woman-listen-music-with-headphone-and-feel-joyful-vector-id1254764171?k=20&m=1254764171&s=612x612&w=0&h=STytmkIfajTCb_VqHubPq1veQXXcsEpXsfjoyN8RqgE=")
)
