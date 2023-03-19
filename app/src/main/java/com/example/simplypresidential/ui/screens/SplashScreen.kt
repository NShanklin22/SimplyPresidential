package com.example.simplypresidential.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.simplypresidential.R
import com.example.simplypresidential.ui.navigation.NavRoutes
import com.example.simplypresidential.ui.theme.GreyLight
import kotlinx.coroutines.delay

// The splash screen will open when the app is first launches
@Composable
fun AnimatedSplashScreen(navController: NavHostController){
    var startAnimation by remember{ mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(NavRoutes.New.route)
    }
    Splash(alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float){
    Box(modifier =
    Modifier
        .fillMaxSize()
        .alpha(alpha)
        .background(GreyLight),
        contentAlignment = Alignment.Center

    ){
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "president"
        )
    }
}