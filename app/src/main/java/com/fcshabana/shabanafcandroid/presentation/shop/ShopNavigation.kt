package com.fcshabana.shabanafcandroid.presentation.shop

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph

@RequiresApi(Build.VERSION_CODES.M)
fun NavGraphBuilder.shopNavGraph(navController: NavHostController) {
    composable(route = DestinationGraph.SHOP_SCREEN_ROUTE){
        ShopScreen()
    }
}