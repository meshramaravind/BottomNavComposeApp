package com.arvind.bottomnavcomposeapp.components

import android.content.res.Configuration
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arvind.bottomnavcomposeapp.navigation.Screen
import com.arvind.bottomnavcomposeapp.navigation.Screens
import com.arvind.bottomnavcomposeapp.ui.theme.colorPrimary
import com.arvind.bottomnavcomposeapp.view.Dashboard

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screens.Home,
        Screens.Search,
        Screens.Category,
        Screens.Cart,
        Screens.Profile
    )
    BottomNavigation(
        backgroundColor = colorPrimary,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



@Composable
@Preview
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = NavController(LocalContext.current))

}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun BottomNavigationBarDarkPreview() {
    BottomNavigationBar(navController = NavController(LocalContext.current))

}
