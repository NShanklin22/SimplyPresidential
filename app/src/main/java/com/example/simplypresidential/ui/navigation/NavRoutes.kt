package com.example.simplypresidential.ui.navigation

sealed class NavRoutes(val route: String){
    object Splash: NavRoutes("splash")
    object Table : NavRoutes("table")
    object Graph : NavRoutes("graph")
    object Overview : NavRoutes("overview")
    object NewEntry: NavRoutes("newEntry")
}
