package com.example.prueba.navigation

sealed class  NavigationEvent{
    data class NavigateTo(
        val appRoute: AppRoute,
        val popUpRoute: AppRoute?=null,
        val inclusive:Boolean=false,
        val singleTop: Boolean=false

    ): NavigationEvent()

    object PopBackStack: NavigationEvent()
    object NavigateUp: NavigationEvent()

}