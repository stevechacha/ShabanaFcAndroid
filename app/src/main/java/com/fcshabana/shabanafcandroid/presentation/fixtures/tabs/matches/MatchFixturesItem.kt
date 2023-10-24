package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.matches

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.presentation.fixtures.Match
import com.fcshabana.shabanafcandroid.presentation.fixtures.MatchResult
import com.fcshabana.shabanafcandroid.presentation.fixtures.Team
import com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.results.TeamColumns

@Composable
fun MatchFixturesItem(match: Match) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = match.date
            )
            Text(
                text = match.competition_type
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamColumns(
                    team = match.home_team,
                    isHomeTeam = true
                )
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .border(1.dp, color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = match.time,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                TeamColumns(
                    team = match.away_team,
                    isHomeTeam = false
                )
            }
            Text(text = "Stadium: ${match.stadium}")
        }
    }
}




// Dummy data for Manchester United
val manchesterUnited = Team(
    "Man Utd",
    R.drawable.ic_home,
    "Old Trafford",
    75000,
    "Ole Gunnar Solskjær",
    "4-2-3-1",
    emptyList(), // Add actual squad data here
    emptyList(), // Add actual staff data here
    "Premier League"
)

// Dummy data for Barcelona
val barcelona = Team(
    "Barcelona",
    R.drawable.ic_shopping_bag,
    "Camp Nou",
    99000,
    "Ronald Koeman",
    "4-3-3",
    emptyList(), // Add actual squad data here
    emptyList(), // Add actual staff data here
    "La Liga"
)
// Dummy function for home match data
fun getDummyHomeMatch(): Match {
    return Match(
        match_id = "123456",
        home_team = manchesterUnited,
        away_team = barcelona,
        date = "2023-07-31",
        time = "19:00",
        competition_type = "Friendly",
        stadium = "Old Trafford",
        referee = "John Smith",
        result = MatchResult(home_team_goals = 2, away_team_goals = 1)
    )
}

// Dummy function for away match data
fun getDummyAwayMatch(): Match {
    return Match(
        match_id = "7891011",
        home_team = barcelona,
        away_team = manchesterUnited,
        date = "2023-08-15",
        time = "20:00",
        competition_type = "Champions League",
        stadium = "Camp Nou",
        referee = "Jane Doe",
        result = MatchResult(home_team_goals = 3, away_team_goals = 0)
    )
}
