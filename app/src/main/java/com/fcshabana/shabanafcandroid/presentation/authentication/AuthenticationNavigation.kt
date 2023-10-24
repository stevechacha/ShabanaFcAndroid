package com.fcshabana.shabanafcandroid.presentation.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph

fun NavGraphBuilder.authenticationNavGraph(navController: NavHostController) {
    composable(route = DestinationGraph.AUTHENTICATION_ROUTE){
        AuthenticationScreen()
    }
}