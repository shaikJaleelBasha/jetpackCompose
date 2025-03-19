package com.smad.compose_firebase

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smad.compose_firebase.view_model.AuthViewModel
import com.smad.compose_firebase.ui.HomePage
import com.smad.compose_firebase.ui.LoginPage
import com.smad.compose_firebase.ui.SignupPage

@Composable
fun MyAppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController, authViewModel) }
        composable("signup") { SignupPage(navController, authViewModel) }
        composable("home") { HomePage(navController, authViewModel) }
    }
}
