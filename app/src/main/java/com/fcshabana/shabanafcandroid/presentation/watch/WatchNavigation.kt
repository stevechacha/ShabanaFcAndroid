package com.fcshabana.shabanafcandroid.presentation.watch

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph


fun NavGraphBuilder.watchNavGraph(navController: NavHostController) {
    composable(route = DestinationGraph.WATCH_SCREEN_ROUTE){
        WatchScreen()
    }
}
