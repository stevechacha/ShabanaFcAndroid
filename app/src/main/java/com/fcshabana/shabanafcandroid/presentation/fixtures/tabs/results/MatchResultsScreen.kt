package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.presentation.fixtures.getDummyData

@Composable
@Preview
fun MatchResultsScreen() {
    val matchResult = getDummyData() // Replace this with actual match data

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(matchResult.size) { index ->
            MatchResultItem(matchResult = matchResult[index])

            // Add a divider between each ResultItems
            if (index < matchResult.size - 1) {
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}