package com.example.simplypresidential

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.simplypresidential.ui.screens.GameOverScreen
import com.example.simplypresidential.ui.screens.GameScreen
import com.example.simplypresidential.ui.screens.GameStatus
import com.example.simplypresidential.ui.screens.NewGameScreen
import com.example.simplypresidential.ui.theme.SimplyPresidentialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplyPresidentialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GameScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route,
    ){
        composable(NavRoutes.Splash.route){
            AnimatedSplashScreen(navController, viewModel)
        }

        composable(NavRoutes.Overview.route){
            OverviewScreen()
        }

        composable(NavRoutes.Table.route){
            TableScreen(allLogs,viewModel)
        }

        composable(NavRoutes.Graph.route){
            GraphScreen()
        }


    }
}
