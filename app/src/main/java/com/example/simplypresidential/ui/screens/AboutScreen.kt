package com.example.simplypresidential.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun AboutScreen(navController: NavController){
    // All widgets will sit under the modifier screen

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = "About",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(20.dp),
            text = "Have you ever wanted to look your friend dead in the eyes and recite the 46 US presidents in order along with the dates they served? Well look no further! Simply Presidential is the app for you. Take a walk through history and maybe even pad your trivia night scores with this fun filled journey of knowledge.",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(20.dp),
            text = "To play simply hit 'New Game' on the main screen, enter the first name, last name, start, and end dates for the president shown. Green means good, red means bad, you got this!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(20.dp),
            text = "Developed by Royal Fruit Studios, really just one person with a slick new desk and love of trivia.",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Button(onClick = {
            navController.navigate("new") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }) {
            Text(
                text = "BACK"
            )
        }

    }
}