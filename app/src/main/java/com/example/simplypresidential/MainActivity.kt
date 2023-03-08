package com.example.simplypresidential

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.ui.navigation.NavRoutes
import com.example.simplypresidential.ui.screens.*
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
                        val viewModel: PresidentViewModel = viewModel()
                        ScreenSetup(viewModel)}
                    }
                }
            }
        }

@Composable
fun ScreenSetup(viewModel: PresidentViewModel){

    val navController = rememberNavController()

    NavigationHost(navController = navController,viewModel)
}

@Composable
fun NavigationHost(navController: NavHostController, viewModel: PresidentViewModel){

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route,
    ){
        composable(NavRoutes.Splash.route){
            AnimatedSplashScreen(navController)
        }

        composable(NavRoutes.New.route){
            NewGameScreen(navController, viewModel)
        }

        composable(NavRoutes.Game.route){
            GameScreen(viewModel,navController)
        }

        composable(NavRoutes.About.route){
            AboutScreen(navController)
        }

        composable(NavRoutes.GameOver.route){
            GameOverScreen(navController,viewModel
            )
        }

        composable(NavRoutes.Victory.route){
            VictoryScreen(navController, viewModel)
        }
    }
}