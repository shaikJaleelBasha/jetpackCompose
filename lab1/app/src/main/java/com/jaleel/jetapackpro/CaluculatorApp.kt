package com.jaleel.jetapackpro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}

@Composable
fun CalculatorScreen() {
    var num1 by remember { mutableStateOf("0") }
    var num2 by remember { mutableStateOf("0") }

    // Get the current activity context
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // First number input
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Enter Number 1") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Second number input
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Enter Number 2") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Buttons for operations
        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                val result = number1 + number2
                val toast = Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT)
                toast.show()
                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel() // This will cancel the Toast after 2 seconds
                }, 2000)
            }) {
                Text("Add")
            }

            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between buttons

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                val result = number1 - number2
                val toast = Toast.makeText(context, "Result is $result", Toast.LENGTH_LONG)
                toast.show()

// Use Handler to make the Toast disappear after 2 seconds (2000 milliseconds)
                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel() // This will cancel the Toast after 2 seconds
                }, 2000)
            }) {
                Text("Sub")
            }

            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between buttons

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                val result = number1 * number2
                Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
            }) {
                Text("Mul")
            }

            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between buttons

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                if (number2 != 0) {
                    val result = number1 / number2
                    Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Div")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCalScreen() {
    CalculatorScreen()
}