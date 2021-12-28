package com.arvind.bottomnavcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arvind.bottomnavcomposeapp.view.*
import com.arvind.bottomnavcomposeapp.viewmodel.MainViewModel

@Composable
fun Navigation(
    navController: NavHostController, viewModel: MainViewModel,
    topTitleBar: MutableState<String>
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screens.Home.route) {
            HomeScreen()
            topTitleBar.value = "Home"
        }
        composable(Screens.Search.route) {
            SearchScreen()
            topTitleBar.value = "Search"
        }
        composable(Screens.Category.route) {
            CategoryScreen()
            topTitleBar.value = "Category"
        }
        composable(Screens.Cart.route) {
            CartScreen()
            topTitleBar.value = "Cart"
        }
        composable(Screens.Profile.route) {
            ProfileScreen()
            topTitleBar.value = "Profile"
        }
    }
}