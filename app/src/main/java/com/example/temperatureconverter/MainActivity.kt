package com.example.temperatureconverter

import android.os.Bundle
import android.service.controls.templates.TemperatureControlTemplate
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MainActivityContent()
                }
            }
        }
    }

    @Composable
    fun Header(image: Int, description: String) {
        Image(
            painter = painterResource(image),
            contentDescription = description,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop //этот аргумент масштабирует изображение
        )
    }

    @Composable
    fun TemperatureText(celsius: Int) {
        val fahrenheit = (celsius.toDouble() * 9 / 5) + 32
        Text("$celsius Celsius is $fahrenheit Fahrenheit")
    }

    @Composable
    fun ConverterButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Convert")
        }
    }

    @Composable
    fun EnterTemperature(temperature: String, changed: (String) -> Unit) {
        TextField(
            value = temperature,
            label = { Text("Введите температуру в градусах по Цельсию") },
            onValueChange = changed,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun MainActivityContent() {
        val celcius = remember {
            mutableStateOf(0)
        }
        val newCelsius = remember {
            mutableStateOf(" ")
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Header(R.drawable.img, "sunrise image")
            EnterTemperature(newCelsius.value) {
                newCelsius.value = it
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                ConverterButton {
                    newCelsius.value.toIntOrNull()?.let { celcius.value = it }

                }
            }
            TemperatureText(celcius.value)
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainActivity() {
        MaterialTheme {
            Surface {
                MainActivityContent()
            }

        }
    }
}