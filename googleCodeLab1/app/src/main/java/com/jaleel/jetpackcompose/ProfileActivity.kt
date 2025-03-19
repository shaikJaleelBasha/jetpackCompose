package com.jaleel.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaleel.jetpackcompose.ui.theme.JetpackComposeTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // Surface with red background
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Red)
                ) {
                    // Call MyApp1 only once
                    MyApp1()
                }
            }
        }
    }
}

@Composable
fun MyApp1( modifier: Modifier = Modifier.fillMaxSize()) {
    // LazyColumn for better performance when displaying large lists
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(20) { index ->
            CardItem(
                imageUrl = "https://www.example.com/your-image.jpg",
                name = "Sample Name $index", // Add index to make each name unique
                description = "This is a description of the card item."
            )
        }
    }
}

@Composable
fun CardItem(imageUrl: String, name: String, description: String) {

    val expanded = remember { mutableStateOf(false) }
    val bg = if(expanded.value) 48.dp  else 0.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
         // Ensure the elevation is specified as Dp type (using 4.dp)
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Image section
            // Use painterResource for local drawable image
            val painter = painterResource(id = R.drawable.ic_launcher_foreground)  // Ensure this drawable exists
            Image(
                painter = painter,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.Green),
                contentScale = ContentScale.Crop
            )

            // Name section
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(bottom = bg)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

            // Description section
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))

            Button(onClick = {
                  expanded.value = !expanded.value
            }) {
                Text(if(expanded.value) "show less" else "show more")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        // Sample preview with a single card
        CardItem(
            imageUrl = "https://www.example.com/your-image.jpg",
            name = "Sample Name",
            description = "This is a description of the card item."
        )
    }
}

@Preview(showBackground = true)
@Composable
fun showMyApp() {
    JetpackComposeTheme {
        MyApp1()
    }
}
