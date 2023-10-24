package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.presentation.fixtures.LeagueTableEntry


@Composable
fun PremierLeagueTable(tableData: List<LeagueTableEntry>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        item {
            PremierLeagueTableHeaderComponent()
        }

        items(tableData.size) { index ->
            val entry = tableData[index]
            PremierLeagueTableRow(entry = entry)
        }
    }
}

@Composable
fun PremierLeagueTableHeaderComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "")
        TextRow(
            text = "Team",
            modifier = Modifier.fillMaxWidth(0.32f),
        )
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextRow(text = "P")
            TextRow(text = "W")
            TextRow(text = "D")
            TextRow(text = "L")
            TextRow(text = "GD")
            TextRow(text = "Pts")

        }

    }
}
@Composable
fun PremierLeagueTableRow(entry: LeagueTableEntry) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = entry.position.toString())
        TeamRow(team = entry.team)
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        )
        {

            TextRow(text = entry.played_matches.toString())
            TextRow(text = entry.wins.toString())
            TextRow(text = entry.draws.toString())
            TextRow(text = entry.losses.toString())
            TextRow(text = entry.goal_difference.toString())
            TextRow(text = entry.points.toString())

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PremierLeagueTablePreview() {
    val dummyData = getDummyPremierLeagueTableData()
    PremierLeagueTable(dummyData)
}

