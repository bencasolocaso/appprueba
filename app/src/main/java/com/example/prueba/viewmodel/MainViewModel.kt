package com.example.prueba.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import com.example.prueba.navigation.AppRoute
import com.example.prueba.navigation.NavigationEvent


class MainViewModel: ViewModel() {


    private val _navEvents= MutableSharedFlow<NavigationEvent>()
    val navEvents= _navEvents.asSharedFlow()

    fun navigateTo(appRoute: AppRoute){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavigationEvent.NavigateTo(appRoute))
        }
    }

    fun navigateBack(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavigationEvent.NavigateUp)
        }
    }




}
