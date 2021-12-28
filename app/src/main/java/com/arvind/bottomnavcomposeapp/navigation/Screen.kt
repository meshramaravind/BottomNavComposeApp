package com.arvind.bottomnavcomposeapp.navigation

import android.annotation.SuppressLint
import com.arvind.bottomnavcomposeapp.R

sealed class Screen(val route: String) {
    @SuppressLint("CustomSplashScreen")
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object SearchScreen : Screen("search_screen")
    object CategoryScreen : Screen("category_screen")
    object CartScreen : Screen("cart_screen")
    object ProfileScreen : Screen("profile_screen")
}

sealed class Screens(var route: String, var icon: Int, var title: String) {
    object Splash : Screens("splash_screen", 0, "Splash")
    object Home : Screens("home", R.drawable.ic_baseline_home_24, "Home")
    object Search : Screens("search", R.drawable.ic_baseline_search_24, "Search")
    object Category : Screens("category", R.drawable.ic_baseline_list_24, "Category")
    object Cart : Screens("cart", R.drawable.ic_baseline_shopping_cart_24, "Cart")
    object Profile : Screens("profile", R.drawable.ic_baseline_person_24, "Profile")
}


