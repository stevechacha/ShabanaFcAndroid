package com.fcshabana.shabanafcandroid.presentation.fixtures

import com.fcshabana.shabanafcandroid.R

data class Team(
    val team_name: String,
    val team_logo: Int,
    val stadium_name: String,
    val stadium_capacity: Int,
    val manager: String,
    val formation: String,
    val squad: List<Player>,
    val staff: List<Staff>,
    val current_league: String
)

data class Player(
    val player_first_name: String,
    val player_last_name: String,
    val nationality: String,
    val image_url: Int,
    val age: Int,
    val position: String,
    val jersey_number: Int,
    val contract_expiry_date: String,
    val market_value: Double,
    val goals_scored: Int,
    val assists: Int,
    val yellow_cards: Int,
    val red_cards: Int
)

data class Staff(
    val staff_first_name: String,
    val staff_last_name: String,
    val image_url: Int,
    val nationality: String,
    val age: Int,
    val role: String,
    val contract_expiry_date: String,
    val experience_years: Int
)

data class Match(
    val match_id: String,
    val home_team: Team,
    val away_team: Team,
    val date: String,
    val time: String,
    val competition_type: String,
    val stadium: String,
    val referee: String,
    val result: MatchResult
)

data class MatchResult(
    val home_team_goals: Int,
    val away_team_goals: Int
)

data class LeagueTableEntry(
    val team: Team,
    val played_matches: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goals_for: Int,
    val goals_against: Int,
    val goal_difference: Int,
    val points: Int,
    val position: Int
)

data class Competition(
    val competition_name: String,
    val start_date: String,
    val end_date: String,
    val participating_teams: List<Team>,
    val current_matchday: Int
)

data class Stadium(
    val stadium_name: String,
    val location: String,
    val capacity: Int,
    val facilities: List<String>
)

data class NewsArticle(
    val headline: String,
    val author: String,
    val publication_date: String,
    val content: String,
    val tags: List<String>,
    val image_url: String
)

data class Notification(
    val title: String,
    val message: String,
    val timestamp: Long,
    val is_read: Boolean
)

data class FriendlyMatch(
    val match_id: String,
    val home_team: Team,
    val away_team: Team,
    val date: String,
    val time: String,
    val stadium: String,
    val result: MatchResult
)

data class UefaMatch(
    val match_id: String,
    val home_team: Team,
    val away_team: Team,
    val date: String,
    val time: String,
    val stadium: String,
    val result: MatchResult
)


fun getDummyData(): List<Match> {
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

    val realMadrid = Team(
        "Real Madrid",
        R.drawable.opponent_icon,
        "Santiago Bernabéu",
        80000,
        "Carlo Ancelotti",
        "4-4-2",
        emptyList(), // Add actual squad data here
        emptyList(), // Add actual staff data here
        "La Liga"
    )

    val liverpool = Team(
        "Liverpool",
        R.drawable.ic_play_circle,
        "Anfield",
        60000,
        "Jürgen Klopp",
        "4-3-3",
        emptyList(), // Add actual squad data here
        emptyList(), // Add actual staff data here
        "Premier League"
    )

    // Match result where Manchester United wins
    val manUtdWinResult = MatchResult(home_team_goals = 2, away_team_goals = 1)

    val match1 = Match(
        match_id = "123456",
        home_team = manchesterUnited,
        away_team = barcelona,
        date = "2023-07-31",
        time = "19:00",
        competition_type = "Friendly",
        stadium = "Old Trafford",
        referee = "John Smith",
        result = manUtdWinResult
    )

    // Match result where Manchester United loses
    val manUtdLossResult = MatchResult(home_team_goals = 0, away_team_goals = 3)

    val match2 = Match(
        match_id = "7891011",
        home_team = barcelona,
        away_team = manchesterUnited,
        date = "2023-08-15",
        time = "20:00",
        competition_type = "Champions League",
        stadium = "Camp Nou",
        referee = "Jane Doe",
        result = manUtdLossResult
    )

    // Match result where Manchester United draws
    val manUtdDrawResult = MatchResult(home_team_goals = 1, away_team_goals = 1)

    val match3 = Match(
        match_id = "12131415",
        home_team = manchesterUnited,
        away_team = barcelona,
        date = "2023-08-25",
        time = "17:30",
        competition_type = "Premier League",
        stadium = "Old Trafford",
        referee = "Robert Johnson",
        result = manUtdDrawResult
    )

    // More matches with different outcomes for Manchester United
    val match4 = Match(
        match_id = "16171819",
        home_team = manchesterUnited,
        away_team = realMadrid,
        date = "2023-09-05",
        time = "18:45",
        competition_type = "Friendly",
        stadium = "Old Trafford",
        referee = "Sarah Williams",
        result = manUtdDrawResult
    )

    val match5 = Match(
        match_id = "20212223",
        home_team = liverpool,
        away_team = manchesterUnited,
        date = "2023-09-20",
        time = "16:00",
        competition_type = "Premier League",
        stadium = "Anfield",
        referee = "Michael Brown",
        result = manUtdLossResult
    )

    val match6 = Match(
        match_id = "24252627",
        home_team = manchesterUnited,
        away_team = liverpool,
        date = "2023-09-30",
        time = "15:00",
        competition_type = "Premier League",
        stadium = "Old Trafford",
        referee = "David Johnson",
        result = manUtdDrawResult
    )

    return listOf(match1, match2, match3, match4, match5, match6)
}
