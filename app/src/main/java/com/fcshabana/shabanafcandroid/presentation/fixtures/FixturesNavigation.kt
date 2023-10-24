package com.fcshabana.shabanafcandroid.presentation.fixtures

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph


fun NavGraphBuilder.fixturesNavGraph(navController: NavHostController) {
    composable(route = DestinationGraph.FIXTURES_SCREEN_ROUTE){
        FixturesScreen()
    }
}
