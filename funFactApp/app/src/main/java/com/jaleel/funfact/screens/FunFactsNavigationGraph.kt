package com.jaleel.funfact.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun FunFactsNavigationGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {


        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(navController= navController)
        }

        composable(Routes.USER_WELCOME_SCREEN) {
            WelcomeScreen(navController= navController)
        }
    }
}