package com.fcshabana.shabanafcandroid.bottomNav

import androidx.annotation.DrawableRes
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.common.util.DestinationGraph

enum class BottomBarDestinations(val route: String, @DrawableRes val icon: Int, val title: String) {
    LATEST(DestinationGraph.LATEST_SCREEN_ROUTE, R.drawable.ic_home, "Latest"),
    FIXTURES(DestinationGraph.FIXTURES_SCREEN_ROUTE, R.drawable.ic_fixture_available, "Fixtures"),
    WATCH(DestinationGraph.WATCH_SCREEN_ROUTE, R.drawable.ic_play_circle, "Watch"),
    SHOP(DestinationGraph.SHOP_SCREEN_ROUTE, R.drawable.ic_shopping_bag, "Shop"),

}