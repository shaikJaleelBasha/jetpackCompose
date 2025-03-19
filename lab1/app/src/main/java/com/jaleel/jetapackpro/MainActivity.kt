package com.jaleel.jetapackpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jaleel.jetapackpro.ui.theme.JetaPacKProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Assuming this is a method you defined to handle edge-to-edge UI
        setContent {
            MaterialTheme{  // Corrected theme name to "CalculatorTheme"
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Caluculator(modifier = Modifier.padding(innerPadding)) // Corrected variable name
                }
            }
        }
    }
}








@Preview(showBackground = true)
@Composable
fun showCaluculator(){
    Caluculator()

}