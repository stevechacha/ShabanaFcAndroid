package com.fcshabana.shabanafcandroid.presentation.latest

import android.content.Context
import com.fcshabana.shabanafcandroid.R

sealed interface Streamable {
    val streamInfo: StreamInfo
}

/**
 * A class that contains contains information about a specific [Streamable].
 * Note that it is possible that a class may contain a null [streamUrl] because
 * the link might not be available for that specific instance.
 * For example, an API might return a list of tracks with a nullable
 * preview url, where the preview url for certain tracks might be null.
 */
data class StreamInfo(
    val streamUrl: String?,
    val imageUrl: String,
    val title: String,
    val subtitle: String,
)

sealed class SearchResult {
    /**
     * A class that models the result of a search operation for a
     * specific album.
     * Note: The [artistsString] property is meant to hold a comma separated
     * list of artists who worked on the album.
     */
    data class AlbumSearchResult(
        val id: String,
        val name: String,
        val artistsString: String,
        val albumArtUrlString: String,
        val yearOfReleaseString: String,
    ) : SearchResult()

    /**
     * A class that models the result of a search operation for a
     * specific artist.
     */
    data class ArtistSearchResult(
        val id: String,
        val name: String,
        val imageUrlString: String?
    ) : SearchResult()

    /**
     * A class that models the result of a search operation for a
     * specific playlist.
     */
    data class PlaylistSearchResult(
        val id: String,
        val name: String,
        val ownerName: String,
        val totalNumberOfTracks: String,
        val imageUrlString: String?
    ) : SearchResult()

    /**
     * A class that models the result of a search operation for a
     * specific track.
     * Note: The [artistsString] property is meant to hold a comma separated
     * list of artists who worked on the track.
     */
    data class TrackSearchResult(
        val id: String,
        val name: String,
        val imageUrlString: String,
        val artistsString: String,
        val trackUrlString: String?
    ) : SearchResult(), Streamable {
        override val streamInfo = StreamInfo(
            streamUrl = trackUrlString,
            imageUrl = imageUrlString,
            title = name,
            subtitle = artistsString
        )
    }

    data class PodcastSearchResult(
        val id: String,
        val name: String,
        val nameOfPublisher: String,
        val imageUrlString: String,
    ) : SearchResult()

    data class EpisodeSearchResult(
        val id: String,
        val episodeContentInfo: EpisodeContentInfo,
        val episodeReleaseDateInfo: EpisodeReleaseDateInfo,
        val episodeDurationInfo: EpisodeDurationInfo
    ) : SearchResult() {
        data class EpisodeContentInfo(
            val title: String,
            val description: String,
            val imageUrlString: String
        )

        data class EpisodeReleaseDateInfo(val month: String, val day: Int, val year: Int)
        data class EpisodeDurationInfo(val hours: Int, val minutes: Int)
    }
}

/**
 * A utility method used to get a string that contains date and duration
 * information in a formatted manner for an instance of
 * [SearchResult.EpisodeSearchResult].
 * @see generateMusifyDateAndDurationString
 *
 */

fun SearchResult.EpisodeSearchResult.getFormattedDateAndDurationString(context: Context): String =
    generateMusifyDateAndDurationString(
        context = context,
        month = episodeReleaseDateInfo.month,
        day = episodeReleaseDateInfo.day,
        year = episodeReleaseDateInfo.year,
        hours = episodeDurationInfo.hours,
        minutes = episodeDurationInfo.minutes
    )
/*

fun SearchResult.EpisodeSearchResult.getFormattedDateAndDurationString(context: Context): String =
    generateMusifyDateAndDurationString(
        context = context,
        month = episodeReleaseDateInfo.month,
        day = episodeReleaseDateInfo.day,
        year = episodeReleaseDateInfo.year,
        hours = episodeDurationInfo.hours,
        minutes = episodeDurationInfo.minutes
    )*/


fun generateMusifyDateAndDurationString(
    context: Context,
    month: String,
    day: Int,
    year: Int,
    hours: Int,
    minutes: Int
): String {
    val dateString = "$month $day, $year"
    val hourString = if (hours == 0) ""
    else context.getQuantityStringResource(
        id = R.plurals.numberOfHoursOfEpisode,
        quantity = hours,
        formatArgs = arrayOf(hours)
    )
    val minuteString = context.getQuantityStringResource(
        id = R.plurals.numberOfMinutesOfEpisode,
        quantity = minutes,
        formatArgs = arrayOf(minutes)
    )
    return "$dateString • $hourString $minuteString"
}

/**
 * Since [Context.getResources] is a java method, it cannot used named args.
 * This extension function is a wrapper, that just uses [Context.getResources]
 * to get a quantity string. Since this function is a kotlin function, the
 * allows the caller to use named arguments.
 */
private fun Context.getQuantityStringResource(
    id: Int,
    quantity: Int,
    vararg formatArgs: Any? = emptyArray()
) = resources.getQuantityString(id, quantity, *formatArgs)
