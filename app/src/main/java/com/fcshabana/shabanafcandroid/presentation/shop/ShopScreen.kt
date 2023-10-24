package com.fcshabana.shabanafcandroid.presentation.shop

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.presentation.fixtures.FixturesTopBar
import com.fcshabana.shabanafcandroid.presentation.latest.LatestFeedCard

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun ShopScreen() {
    Scaffold(
        topBar = {
            FixturesTopBar(title = "Shop")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item(span = { GridItemSpan(2) }) {
                }

                item(span = { GridItemSpan(2) }) {
                    Text(text = "KITS", fontWeight = FontWeight.W700)
                }
                items(4) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    ) {
                        // Image with content scale to cover entire box
                        Image(
                            painter = painterResource(id = R.drawable.save_image), // Replace R.drawable.your_image with your image resource
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds

                        )

                        // Text placed in the center of the box
                        Text(
                            text = "Your Text",
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(8.dp)
                        )
                    }

                }
                item(span = { GridItemSpan(2) }) {
                    Text(text = "PLAYERS", fontWeight = FontWeight.W700)

                }

                items(10) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    Text(text = "TRAINING 23/24", fontWeight = FontWeight.W700)

                }
                items(10) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = "Product List",
                    )
                }


            }

        }

    }
}

@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalMaterialApi
@Composable
private fun CarouselLazyRow(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
) {
    val player = playerList
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // not using keys because the items do not change
        items(player.size) { card ->
            LatestFeedCard(
                imageUrlString = card.toString(),
                caption = card.toString(),
            )
        }
    }
}


data class Player(
    val name: String,
    val imageUrl: Int
)

val playerList = listOf(
    Player(
        name = "Rashford",
        R.drawable.ic_home
    ),
    Player(
        name = "Nani",
        R.drawable.ic_play_circle
    )
)
