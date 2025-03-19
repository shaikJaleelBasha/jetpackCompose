package com.jaleel.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaleel.weather_app.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private val apiKey = "f73b51839810940aaa34e0f339af2c51" // API Key as a variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                MainScreenContent(apiKey)
            }
        }
    }
}

@Composable
fun MainScreenContent(apiKey: String) {
    WeatherAppScreen(apiKey)
}

@Composable
fun WeatherAppScreen(apiKey: String) {
    val weatherViewModel: WeatherViewModel = viewModel()
    var city by remember { mutableStateOf("") }
    val weatherData by weatherViewModel.weatherData.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            TextField(
                value = city,
                onValueChange = { city = it },
                label = { Text(stringResource(R.string.enter_city)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedIndicatorColor = MaterialTheme.colors.onSurface.copy(alpha = 0.42f),
                    textColor = MaterialTheme.colors.onBackground,
                    focusedLabelColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                    cursorColor = MaterialTheme.colors.primary,
                )
            )

            Button(
                onClick = {
                    if (city.isNotEmpty()) {
                        weatherViewModel.fetchWeather(city, apiKey)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                )
            ) {
                Text(stringResource(R.string.get_weather))
            }

            weatherData?.let { data ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.city_format, data.name),
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = stringResource(R.string.temperature_format, data.main.temp),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = stringResource(R.string.description_format, data.weather[0].description),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            } ?: run {
                if (city.isNotEmpty()) {
                    Text(
                        text = stringResource(R.string.loading),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        MainScreenContent("f73b51839810940aaa34e0f339af2c51")
    }
}