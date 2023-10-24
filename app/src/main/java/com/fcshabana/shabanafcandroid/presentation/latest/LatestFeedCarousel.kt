package com.fcshabana.shabanafcandroid.presentation.latest


/**
 * A domain class the represents a single card in a home feed
 * carousel with the specified [id],[imageUrlString] and [caption].
 * It also contains the [associatedSearchResult] object for this specific
 * carousel card.
 */
data class LatestFeedCarouselCardInfo(
    val id: String,
    val imageUrlString: String,
    val caption: String,
    val associatedSearchResult: SearchResult
)

/**
 * A domain class that contain the [title] and [associatedCards]
 * of a single home feed carousel.
 * @param id the unique id of the car
 */
data class LatestFeedCarousel(
    val id: String,
    val title: String,
    val associatedCards: List<LatestFeedCarouselCardInfo>
)

val carousels = listOf(
    LatestFeedCarousel(
        id = "Hello",
        title = "NNNNNNN",
        associatedCards = listOf()
    )
)


fun generateDummyData(): List<SearchResult> {
    val albumResult1 = SearchResult.AlbumSearchResult(
        id = "album1",
        name = "Album 1",
        artistsString = "Artist A, Artist B",
        albumArtUrlString = "https://example.com/album1.jpg",
        yearOfReleaseString = "2023"
    )

    val artistResult1 = SearchResult.ArtistSearchResult(
        id = "artist1",
        name = "Artist A",
        imageUrlString = "https://example.com/artist1.jpg"
    )

    val playlistResult1 = SearchResult.PlaylistSearchResult(
        id = "playlist1",
        name = "Playlist 1",
        ownerName = "Owner X",
        totalNumberOfTracks = "10",
        imageUrlString = "https://example.com/playlist1.jpg"
    )

    val trackResult1 = SearchResult.TrackSearchResult(
        id = "track1",
        name = "Track 1",
        imageUrlString = "https://example.com/track1.jpg",
        artistsString = "Artist A, Artist B",
        trackUrlString = "https://example.com/track1.mp3"
    )

    val podcastResult1 = SearchResult.PodcastSearchResult(
        id = "podcast1",
        name = "Podcast 1",
        nameOfPublisher = "Publisher Y",
        imageUrlString = "https://example.com/podcast1.jpg"
    )

    val episodeContentInfo1 = SearchResult.EpisodeSearchResult.EpisodeContentInfo(
        title = "Episode 1",
        description = "This is episode 1",
        imageUrlString = "https://example.com/episode1.jpg"
    )
    val episodeReleaseDateInfo1 = SearchResult.EpisodeSearchResult.EpisodeReleaseDateInfo(
        month = "August",
        day = 1,
        year = 2023
    )
    val episodeDurationInfo1 = SearchResult.EpisodeSearchResult.EpisodeDurationInfo(
        hours = 1,
        minutes = 30
    )
    val episodeResult1 = SearchResult.EpisodeSearchResult(
        id = "episode1",
        episodeContentInfo = episodeContentInfo1,
        episodeReleaseDateInfo = episodeReleaseDateInfo1,
        episodeDurationInfo = episodeDurationInfo1
    )

    return listOf(
        albumResult1,
        artistResult1,
        playlistResult1,
        trackResult1,
        podcastResult1,
        episodeResult1
    )
}

fun main() {
    val dummyData = generateDummyData()
    dummyData.forEach { result ->
        when (result) {
            is SearchResult.AlbumSearchResult -> println("Album: ${result.name}, Artists: ${result.artistsString}, Year: ${result.yearOfReleaseString}")
            is SearchResult.ArtistSearchResult -> println("Artist: ${result.name}")
            is SearchResult.PlaylistSearchResult -> println("Playlist: ${result.name}, Owner: ${result.ownerName}, Tracks: ${result.totalNumberOfTracks}")
            is SearchResult.TrackSearchResult -> println("Track: ${result.name}, Artists: ${result.artistsString}")
            is SearchResult.PodcastSearchResult -> println("Podcast: ${result.name}, Publisher: ${result.nameOfPublisher}")
            is SearchResult.EpisodeSearchResult -> println("Episode: ${result.episodeContentInfo.title}, Date: ${result.episodeReleaseDateInfo.month} ${result.episodeReleaseDateInfo.day}, ${result.episodeReleaseDateInfo.year}, Duration: ${result.episodeDurationInfo.hours}h ${result.episodeDurationInfo.minutes}m")
        }
    }
}



