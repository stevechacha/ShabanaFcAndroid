package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.matches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun MatchFixturesScreen() {
    val matches = listOf(getDummyHomeMatch(), getDummyAwayMatch())
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(matches.size) { index ->
                MatchFixturesItem(match = matches[index])
                // Add a divider between each ResultItems
                if (index < matches.size - 1) {
                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            }
        }
    }

}