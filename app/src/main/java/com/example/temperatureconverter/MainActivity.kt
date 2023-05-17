package com.example.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                Hello("Hello!")
                Hello("FRIENDS!!")

            }
        }
    }
}

@Composable
fun Hello(name: String) {
    Text(name)
}

@Preview(showBackground = true)
@Composable
fun PreviewMyActivity() {
    Column() {

        Hello("How")
        Hello("are you?")

    }
}

