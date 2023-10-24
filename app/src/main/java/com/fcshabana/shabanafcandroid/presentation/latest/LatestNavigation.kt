package com.fcshabana.shabanafcandroid.presentation.latest

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph

@RequiresApi(Build.VERSION_CODES.M)
fun NavGraphBuilder.latestNavGraph(navController: NavHostController) {

    composable(route = DestinationGraph.LATEST_SCREEN_ROUTE){
        val latestFeedViewModel = hiltViewModel<LatestViewModel>()

        val filters = remember {
            listOf(
                LatestFeedFilters.Music,
                LatestFeedFilters.PodcastsAndShows
            )
        }
        LatestScreen(
            timeBasedGreeting = latestFeedViewModel.greetingPhrase,
            homeFeedFilters = filters,
            currentlySelectedHomeFeedFilter = LatestFeedFilters.None,
            onHomeFeedFilterClick = {},
            carousels = carousels,
            isErrorMessageVisible = false,
            isLoading = false,
            onErrorRetryButtonClick = {}

        )
    }
}
