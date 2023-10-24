package com.fcshabana.shabanafcandroid.presentation.latest

sealed class LatestFeedFilters(val title: String? = null) {
    object Music : LatestFeedFilters("Music")
    object PodcastsAndShows : LatestFeedFilters("Podcasts & Shows")
    object None : LatestFeedFilters()
}
