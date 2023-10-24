package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.staff

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.fcshabana.shabanafcandroid.presentation.fixtures.Staff

@Composable
fun StaffComponentItem(staff: Staff) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(120.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = staff.staff_first_name,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            Text(
                text = staff.staff_last_name,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Text(
                text = staff.role,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = staff.image_url,
            placeholder = painterResource(id = staff.image_url),
            contentDescription = "Player Avatar",
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp, top = 16.dp),

            )
    }

}