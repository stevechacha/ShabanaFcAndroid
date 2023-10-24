package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.players

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fcshabana.shabanafcandroid.presentation.fixtures.Player


@Composable
fun PlayerComponentItem(player: Player) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(120.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = player.image_url,
            placeholder = painterResource(id = player.image_url),
            contentDescription = "Player Avatar",
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp,top = 16.dp),

            )
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = player.player_first_name,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            Text(
                text = player.player_last_name,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            /*Text(
                text = "Position: ${player.position}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Jersey Number: ${player.jersey_number}",
                fontWeight = FontWeight.Bold

            )*/
        }
    }
}
