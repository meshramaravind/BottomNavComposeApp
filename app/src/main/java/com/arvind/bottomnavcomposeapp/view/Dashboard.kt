package com.arvind.bottomnavcomposeapp.view

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.bottomnavcomposeapp.R
import com.arvind.bottomnavcomposeapp.components.BottomNavigationBar

import com.arvind.bottomnavcomposeapp.ui.theme.colorPrimary

@Composable
fun Dashboard(
) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
                titleSection = sectionState.value
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value
        )
        { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen()
            }
            when (section) {
                DashboardSection.Search -> SearchScreen()
            }
            when (section) {
                DashboardSection.Category -> CategoryScreen()
            }
            when (section) {
                DashboardSection.Cart -> CartScreen()
            }
            when (section) {
                DashboardSection.Profile -> ProfileScreen()
            }
        }
    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
    titleSection: DashboardSection,
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                label = { Text(text = titleSection.title) },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = true
            )
        }
    }
}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
    val title: String
) {
    Home(R.drawable.ic_baseline_home_24, R.drawable.ic_baseline_home_24, "Home"),
    Search(R.drawable.ic_baseline_search_24, R.drawable.ic_baseline_search_24, "Search"),
    Category(R.drawable.ic_baseline_list_24, R.drawable.ic_baseline_list_24, "Category"),
    Cart(R.drawable.ic_baseline_shopping_cart_24, R.drawable.ic_baseline_shopping_cart_24, "Cart"),
    Profile(R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_person_24, "Profile")

}



@Composable
@Preview
fun DashboardPreview() {
    Dashboard()

}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun DashboardDarkPreview() {
    Dashboard()

}
