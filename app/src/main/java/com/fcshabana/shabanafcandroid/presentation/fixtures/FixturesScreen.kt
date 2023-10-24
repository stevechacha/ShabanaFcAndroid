package com.fcshabana.shabanafcandroid.presentation.fixtures

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.fcshabana.shabanafcandroid.common.theme.Montserrat
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table.LeagueTableScreen
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.matches.MatchFixturesScreen
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.players.PlayersScreen
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.results.MatchResultsScreen
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.staff.StaffScreen
import com.fcshabana.shabanafcandroid.presentation.latest.LatestPages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.fcshabana.shabanafcandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun FixturesScreen() {
    val viewModel: FixturesViewModel = viewModel()
    Scaffold(
        topBar = {
           FixturesTopBar(
               title = "Men"
           )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            FixturesPager(viewModel)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FixturesPager(viewModel: FixturesViewModel) {
    val pagerState = rememberPagerState(initialPage = 0)
    val pages = LatestPages.values().asList()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { settledPage ->
            viewModel.onTriggerEvent(FixturesEvent.OnEventPageChange(settledPage))
        }
    }

    val animateContentSizeModifier = Modifier.animateContentSize()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {
            val modifier = Modifier.tabIndicatorOffset(it[pagerState.currentPage])
            TabRowDefaults.Indicator(
                modifier,
                height = 5.dp,
                color = MaterialTheme.colorScheme.primary
            )
        },
        edgePadding = 5.dp,
        divider = {
            Divider(
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f)
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        modifier = animateContentSizeModifier, // Apply animateContentSize modifier
    ) {
        pages.forEachIndexed { index, item ->
            val isSelected = pagerState.currentPage == index
            Tab(
                selected = isSelected,
                onClick = {
                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = MaterialTheme.colorScheme.onBackground,
                text = {
                    Text(
                        text = stringResource(id = item.title),
                        color = if (isSelected) Color.Black else MaterialTheme.colorScheme.onSurface.copy(
                            alpha = 0.6f
                        ),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    )
                },
                modifier = animateContentSizeModifier, // Apply animateContentSize modifier
            )
        }
    }

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        count = pages.size,
        key = { it }
    ) { page ->
        when (page) {
            0 -> MatchFixturesScreen()
            1 -> MatchResultsScreen()
            2 -> LeagueTableScreen()
            3 -> PlayersScreen()
            4 -> StaffScreen()
        }
    }
}

@Composable
fun FixturesTopBar(
    title: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_icon),
                contentDescription = null,
                tint = Color.White
            )
        }
        Text(
            text = title.uppercase(),
            fontFamily = Montserrat,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
        )

        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                contentDescription = "null",
                painter = painterResource(id = R.drawable.ic_person),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }


    }

}


@Composable
@Preview
fun FixturePreview() {
    FixturesScreen()
}