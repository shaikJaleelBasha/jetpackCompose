package com.jaleel.funfact.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jaleel.funfact.R



@Composable
fun TopAppBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, // Correct for vertical alignment
        horizontalArrangement = Arrangement.Center     ) {
        Text(
            text = value,
            fontSize = 40.sp,
            color = Color.Red,
            modifier = Modifier.weight(1f) // Ensures the text stays on the left
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "logo",
            modifier = Modifier
                .background(color = Color.Cyan)
                .padding(8.dp) // Optional: adds some padding to the image
        )
    }
}

@Preview(showBackground = true)
@Composable
fun showTopAppBar() {
    TopAppBar(value = String())
}


@Composable
fun TextSample(value1:String, textSize: TextUnit, colorValue: Color = Color.Black) {
    Column{
        Text(
            text = value1,
            fontSize = 24.sp,
            color = Color.Black
        )

    }
}

@Preview(showBackground = true)
@Composable
fun showText(){
    TextSample(value1 = String(), textSize = 24.sp, colorValue = Color.Black)
}