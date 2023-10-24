package com.fcshabana.shabanafcandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fcshabana.shabanafcandroid.R

@Composable
fun ShirtDesignApp() {
    var shirtNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShirtDesign(shirtNumber)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = shirtNumber,
            onValueChange = { shirtNumber = it },
            label = { Text("Enter Shirt Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(onDone = {
                // You can add any logic you want when the user presses Done on the keyboard.
            })
        )
    }
}

@Composable
fun ShirtDesign(shirtNumber: String) {
    // Implement the shirt design here based on the entered shirtNumber.
    // You can use Jetpack Compose elements to create the shirt design.
    // For example, you can use Image, Text, Box, etc., to build the shirt design UI.
    // The shirtNumber parameter can be used to display the number on the shirt.

    // Here's a simple example to display the shirt number on a shirt image:
    Box(
        modifier = Modifier.width(120.dp)
            .height(1240.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_person), // Replace with your shirt image resource
            contentDescription = "Shirt Design",
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = shirtNumber,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp)
                .align(Alignment.TopCenter)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShirtDesignApp()

}
