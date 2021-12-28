package com.arvind.bottomnavcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.arvind.bottomnavcomposeapp.components.BottomNavigationBar
import com.arvind.bottomnavcomposeapp.components.TopBar
import com.arvind.bottomnavcomposeapp.navigation.Navigation
import com.arvind.bottomnavcomposeapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        val viewModel: MainViewModel = viewModel()
        val currentScreen by viewModel.currentScreen.observeAsState()
        val titles = remember { mutableStateOf("Home") }
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = titles.value)
                })
            },
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            Navigation(navController = navController, viewModel = viewModel, topTitleBar = titles)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }
}




