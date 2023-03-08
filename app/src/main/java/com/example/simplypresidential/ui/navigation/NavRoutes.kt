package com.example.simplypresidential.ui.navigation

sealed class NavRoutes(val route: String){
    object Splash: NavRoutes("splash")
    object New : NavRoutes("new")
    object Game : NavRoutes("game")
    object About : NavRoutes("about")
    object Settings : NavRoutes("settings")
    object GameOver : NavRoutes("GameOver")
    object Victory : NavRoutes("victory")
}
