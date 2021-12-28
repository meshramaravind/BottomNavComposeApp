package com.arvind.bottomnavcomposeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arvind.bottomnavcomposeapp.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() :
    ViewModel() {
    private val _currentScreen = MutableLiveData<Screen>()
    val currentScreen: LiveData<Screen> = _currentScreen

    fun setCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }

    private val _clickCount = MutableLiveData(0)
    val clickCount: LiveData<Int> = _clickCount

    fun updateClick(value: Int) {
        _clickCount.value = value
    }
}