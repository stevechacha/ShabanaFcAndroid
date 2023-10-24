package com.fcshabana.shabanafcandroid.common.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph.AUTHENTICATION_ROUTE
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph.LATEST_SCREEN_ROUTE
import com.fcshabana.shabanafcandroid.presentation.account.accountNavGraph
import com.fcshabana.shabanafcandroid.presentation.authentication.authenticationNavGraph
import com.fcshabana.shabanafcandroid.presentation.fixtures.fixturesNavGraph
import com.fcshabana.shabanafcandroid.presentation.latest.latestNavGraph
import com.fcshabana.shabanafcandroid.presentation.shop.shopNavGraph
import com.fcshabana.shabanafcandroid.presentation.watch.watchNavGraph

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun AppHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = LATEST_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        accountNavGraph(navController)
        latestNavGraph(navController,)
        fixturesNavGraph(navController)
        authenticationNavGraph(navController)
        shopNavGraph(navController)
        watchNavGraph(navController)
    }

}









