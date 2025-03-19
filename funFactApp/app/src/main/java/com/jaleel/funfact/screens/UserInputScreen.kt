package com.jaleel.funfact.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun UserInputScreen(navController: NavHostController) {

    Surface(modifier = Modifier.fillMaxSize()
        .clickable{navController.navigate(Routes.USER_WELCOME_SCREEN)}.padding(18.dp)) {
        Column {
            TopAppBar("Jaleel")
            Spacer(modifier = Modifier.height(10.dp))
            TextSample("hlo sample", 24.sp, Color.Black)
        }


    }

}



@Preview(showBackground = true)
@Composable
fun showUserInputScreen(){
    UserInputScreen(rememberNavController())
}