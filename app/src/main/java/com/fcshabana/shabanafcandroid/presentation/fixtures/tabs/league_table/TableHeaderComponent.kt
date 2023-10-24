package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TableHeaderComponent() {
    val titleHeaderWithPositionLogoNameOnly = listOf("", "Team", "")
    val titles = listOf("P", "W", "D", "L", "GD", "Pts")

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        titleHeaderWithPositionLogoNameOnly.forEach { titleHeaderWithPositionLogoNameOnly ->
            Box(
                modifier = Modifier
                    .weight(.2f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = titleHeaderWithPositionLogoNameOnly,
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
        titles.forEach { title ->
            Box(
                modifier = Modifier
                    .weight(.2f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = title,
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

@Composable
@Preview(showBackground = true)
fun TableHeaderComponentPreview() {
    val titleHeaderWithPositionLogoNameOnly = listOf("TeamAndLogoButStayBlank")
    val titles = listOf("P", "W", "D", "L","GD","Pts")

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        titleHeaderWithPositionLogoNameOnly.forEach { titleHeaderWithPositionLogoNameOnly->
            Box(
                modifier = Modifier
                    .weight(.2f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = titleHeaderWithPositionLogoNameOnly,
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
        titles.forEach { title ->
            Box(
                modifier = Modifier
                    .weight(.2f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = title,
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

