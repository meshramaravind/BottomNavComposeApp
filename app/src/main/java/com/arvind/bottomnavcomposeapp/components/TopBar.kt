package com.arvind.bottomnavcomposeapp.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.arvind.bottomnavcomposeapp.ui.theme.colorPrimary

@Composable
fun TopBar(title: String="") {
    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp) },
        backgroundColor = colorPrimary,
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(title = "Home")
}