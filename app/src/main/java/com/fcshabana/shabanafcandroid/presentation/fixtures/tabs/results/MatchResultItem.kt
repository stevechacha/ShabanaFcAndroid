package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.results

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fcshabana.shabanafcandroid.presentation.fixtures.Match
import com.fcshabana.shabanafcandroid.presentation.fixtures.MatchResult
import com.fcshabana.shabanafcandroid.presentation.fixtures.Team

@Composable
fun MatchResultItem(matchResult: Match) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = matchResult.date,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = matchResult.competition_type,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamColumns(
                    team = matchResult.home_team,
                    isHomeTeam = true
                )
                ScoreColumns(matchResult.result)
                TeamColumns(
                    team = matchResult.away_team,
                    isHomeTeam = false
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                // Display match result (W, L, or D) based on the scores
                when {
                    matchResult.result.home_team_goals > matchResult.result.away_team_goals -> {
                        if (matchResult.home_team.team_name == "Man Utd") {
                            Text(
                                text = "W",
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp, fontWeight = FontWeight.Bold
                            )
                        } else {
                            Text(
                                text = "L",
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    matchResult.result.home_team_goals < matchResult.result.away_team_goals -> {
                        if (matchResult.home_team.team_name == "Man Utd") {
                            Text(
                                text = "L",
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            Text(
                                text = "W",
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    else -> {
                        Text(
                            text = "D",
                            color = Color.Yellow,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp, fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun TeamColumns(team: Team, isHomeTeam: Boolean) {
    Column(
        horizontalAlignment = if (isHomeTeam) Alignment.Start else Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = team.team_logo,
            contentDescription = "Team Logo",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = team.team_logo)
        )

        Text(
            text = team.team_name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun ScoreColumns(score: MatchResult) {
    Box(
        modifier = Modifier
            .height(32.dp)
            .width(64.dp)
            .border(width = 1.dp, color = Color.Black),
        contentAlignment = Alignment.Center,

        ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = score.home_team_goals.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Text(
                text = "FT",
                fontSize = 14.sp,
                color = Color.Gray,
            )
            Text(
                text = score.away_team_goals.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
        }
    }
}





