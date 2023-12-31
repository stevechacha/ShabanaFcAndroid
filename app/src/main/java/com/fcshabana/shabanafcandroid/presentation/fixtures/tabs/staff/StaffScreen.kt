package com.fcshabana.shabanafcandroid.presentation.fixtures.tabs.staff

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StaffScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(staffList.size){ index ->
                StaffComponentItem(staff = staffList[index])
            }
        }
    }
}

@Composable
@Preview
fun StaffScreenPreview() {
    StaffScreen()
}


