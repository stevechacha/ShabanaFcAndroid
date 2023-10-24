package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table

import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.presentation.fixtures.LeagueTableEntry
import com.fcshabana.shabanafcandroid.presentation.fixtures.Team


fun getDummyPremierLeagueTableData(): List<LeagueTableEntry> {
    return listOf(
        LeagueTableEntry(
            team = Team(
                "Man Utd",
                R.drawable.ic_home,
                "Old Trafford",
                75000,
                "Ole Gunnar Solskjær",
                "4-2-3-1",
                emptyList(),
                emptyList(),
                "Premier League"
            ),
            played_matches = 20,
            wins = 15,
            draws = 3,
            losses = 2,
            goals_for = 40,
            goals_against = 15,
            goal_difference = 25,
            points = 48,
            position = 1
        ),
        LeagueTableEntry(
            team = Team(
                "Man City",
                R.drawable.ic_play_circle,
                "Etihad Stadium",
                55000,
                "Pep Guardiola",
                "4-3-3",
                emptyList(),
                emptyList(),
                "Premier League"
            ),
            played_matches = 20,
            wins = 14,
            draws = 4,
            losses = 2,
            goals_for = 38,
            goals_against = 20,
            goal_difference = 18,
            points = 46,
            position = 2
        ),
        LeagueTableEntry(
            team = Team(
                "Liverpool",
                R.drawable.ic_fixture_available,
                "Anfield",
                53000,
                "Jurgen Klopp",
                "4-3-3",
                emptyList(),
                emptyList(),
                "Premier League"
            ),
            played_matches = 20,
            wins = 12,
            draws = 5,
            losses = 3,
            goals_for = 35,
            goals_against = 17,
            goal_difference = 18,
            points = 41,
            position = 3
        ),
    )
}


