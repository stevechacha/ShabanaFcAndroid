package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fcshabana.shabanafcandroid.presentation.fixtures.LeagueTableEntry

@Composable
fun TableRowComponent(entry: LeagueTableEntry) {
    val teamNameOnly = listOf(entry.team.team_name)
    val teamPosition = listOf(entry.position.toString())
    val teamLogo = listOf(entry.team.team_logo)
    val teamPWDLGDAndPtsOnly = listOf(
        entry.played_matches.toString(),
        entry.wins.toString(),
        entry.draws.toString(),
        entry.losses.toString(),
        entry.goal_difference.toString(),
        entry.points.toString()
    )

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        teamPosition.forEach { teamPosition ->
            Box(
                modifier = Modifier
                    .weight(.1f),
                contentAlignment = Alignment.Center,
            ) {

                Text(
                    text = teamPosition,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(38.dp)
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center,
                )
            }

        }
        teamLogo.forEach { teamLogo ->
            Box(
                modifier = Modifier
                    .weight(.1f)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = teamLogo,
                    contentDescription = teamLogo.toString(),
                    modifier = Modifier.size(24.dp),
                    placeholder = painterResource(id = teamLogo) // Replace with a placeholder image resource
                )
            }

        }
        teamNameOnly.forEach { teamNameOnly ->
            Box(
                modifier = Modifier
                    .weight(.4f),
                contentAlignment = Alignment.Center,
            ) {

                Text(
                    text = teamNameOnly,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(38.dp)
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center,
                )
            }

        }

        teamPWDLGDAndPtsOnly.forEach { teamPWDLGDAndPtsOnly ->
            Box(
                modifier = Modifier
                    .weight(.2f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = teamPWDLGDAndPtsOnly,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(38.dp)
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}