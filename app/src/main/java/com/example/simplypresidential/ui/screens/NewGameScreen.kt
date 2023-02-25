package com.example.simplypresidential.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.simplypresidential.database.PresidentData
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.database.PresidentsList
import com.example.simplypresidential.database.PresidentsList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewGameScreen(navController: NavController, viewModel:PresidentViewModel){
    // All widgets will sit under the modifier screen

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = "Simply Presidential: Memorize the Presidents",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )

        Box(modifier = Modifier.fillMaxWidth().height(300.dp) ){
            PresidentialSlider()
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(
                modifier = Modifier.width(150.dp),
                onClick = {
                    navController.navigate("game") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text(
                    text = "New Game"
                )
            }

            Button(
                modifier = Modifier.width(150.dp),
                onClick = {
                    navController.navigate("about") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text(
                    text = "About"
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun PresidentialSlider(){

    val pagerState = rememberPagerState(initialPage = 1)

    LaunchedEffect(Unit) {
        while(true) {
            yield()
            delay(2000)
            tween<Float>(600)
            pagerState.animateScrollToPage(
                page = (Math.random()*2).toInt() //(pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    HorizontalPager(
        count = PresidentsList.size,
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
    ) {
        page -> PresidentImage(pager = PresidentsList[page])
    }
}

@Composable
fun PresidentImage(pager:PresidentData){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(painter = painterResource(id = pager.image), contentDescription = pager.FirstName)

        Text(pager.FirstName)
    }
}
