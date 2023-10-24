package com.fcshabana.shabanafcandroid.presentation.watch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fcshabana.shabanafcandroid.presentation.fixtures.FixturesTopBar

@Composable
fun WatchScreen() {
    Scaffold(topBar = { FixturesTopBar(title = "Watch") }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }

    }
}