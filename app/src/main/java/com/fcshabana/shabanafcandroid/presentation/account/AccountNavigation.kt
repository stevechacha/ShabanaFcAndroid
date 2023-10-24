package com.fcshabana.shabanafcandroid.presentation.account

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph

fun NavGraphBuilder.accountNavGraph(navController: NavHostController) {
    composable(route = DestinationGraph.ACCOUNT_ROUTE){
        AccountScreen()
    }
}