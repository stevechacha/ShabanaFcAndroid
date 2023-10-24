package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.league_table

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fcshabana.shabanafcandroid.R
import com.fcshabana.shabanafcandroid.common.theme.Montserrat
import com.fcshabana.shabanafcandroid.presentation.fixtures.LeagueTableEntry
import com.fcshabana.shabanafcandroid.presentation.fixtures.Team
import kotlin.reflect.KProperty1
import kotlin.reflect.full.primaryConstructor

@Composable
fun PremierLeagueTableContent(tableData: List<LeagueTableEntry>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TableHeaderComponent()
        }

        items(tableData.size) { index ->
            val entry = tableData[index]
            TableRowComponent(entry = entry)
        }
    }
}


@Composable
fun LeagueTableScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dummyData = getDummyPremierLeagueTableData()
        PremierLeagueTableContent(dummyData)
    }

}





@Preview
@Composable
fun LeagueTableScreenPreview() {
    val dummyData = getDummyPremierLeagueTableData()
    PremierLeagueTable(dummyData)
}
