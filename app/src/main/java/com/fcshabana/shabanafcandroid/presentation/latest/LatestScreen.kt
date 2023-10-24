package com.fcshabana.shabanafcandroid.presentation.latest

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.common.components.DefaultShabanaErrorMessage
import com.fcshabana.shabanafcandroid.common.components.DefaultShabanaLoadingAnimation
import com.fcshabana.shabanafcandroid.common.components.ShabanaToolBar
import com.fcshabana.shabanafcandroid.common.theme.Montserrat
import com.fcshabana.shabanafcandroid.util.ShabanaBottomNavigationConstants
import com.fcshabana.shabanafcandroid.util.ShabanaMiniPlayerConstants

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun LatestScreen(
    timeBasedGreeting: String,
    homeFeedFilters: List<LatestFeedFilters>,
    currentlySelectedHomeFeedFilter: LatestFeedFilters,
    onHomeFeedFilterClick: (LatestFeedFilters) -> Unit = {},
    carousels: List<LatestFeedCarousel>,
    onErrorRetryButtonClick: () -> Unit = {},
    isLoading: Boolean = false,
    isErrorMessageVisible: Boolean = false,
) {
    val lazyColumState = rememberLazyListState()
    val isStatusbarSpacerVisible = remember {
        derivedStateOf { lazyColumState.firstVisibleItemIndex > 1 }
    }
    val lazyColumBottomPaddingValues = remember {
        ShabanaBottomNavigationConstants.navigationHeight + ShabanaMiniPlayerConstants.miniPlayerHeight
    }
    val errorMessageItem = @Composable { modifier: Modifier ->
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultShabanaErrorMessage(
                title = "Oops! Something doesn't look right",
                subtitle = "Please check the internet connection",
                onRetryButtonClicked = onErrorRetryButtonClick
            )
        }
    }
    Box {
        LazyColumn(
            state = lazyColumState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = lazyColumBottomPaddingValues)
        ) {
            item {
                ShabanaToolBar(
                    title = timeBasedGreeting,
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding(),
                    actions = {}
                )
            }
            item {

            }
            stickyHeader {
                if (isStatusbarSpacerVisible.value) {
                    Spacer(
                        modifier = Modifier
                            .background(androidx.compose.material.MaterialTheme.colors.background)
                            .fillMaxWidth()
                            .windowInsetsTopHeight(WindowInsets.statusBars)
                    )
                }
                Row(
                    modifier = Modifier
                        .background(androidx.compose.material.MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    for (homeFeedFilter in homeFeedFilters) {
                        ShabanaFilterChip(
                            text = homeFeedFilter.title ?: continue,
                            onClick = { onHomeFeedFilterClick(homeFeedFilter) },
                            isSelected = homeFeedFilter == currentlySelectedHomeFeedFilter
                        )
                    }
                }
            }
            if (isErrorMessageVisible) {
                item {
                    errorMessageItem(
                        Modifier
                            .fillParentMaxSize()
                            .padding(bottom = lazyColumBottomPaddingValues)
                    )
                }
            } else {
                // not using keys because the items do not change
                items(10) { carousel ->
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = carousel.toString(),
                        fontWeight = FontWeight.Bold,
                        style = androidx.compose.material.MaterialTheme.typography.h5
                    )
                    CarouselLazyRow(
                        modifier = Modifier.fillMaxWidth(),

                    )
                }
            }
        }
        DefaultShabanaLoadingAnimation(
            isVisible = isLoading,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalMaterialApi
@Composable
private fun CarouselLazyRow(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp)
) {
    val carousel = carousels
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // not using keys because the items do not change
        items(5) { card ->
            LatestFeedCard(
                imageUrlString = card.toString(),
                caption = card.toString(),
            )
        }
    }
}



