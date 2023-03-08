package com.example.simplypresidential.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.database.PresidentsList
import com.example.simplypresidential.ui.theme.IncorrectRed


@Composable
fun GameOverScreen(navController: NavController, viewModel: PresidentViewModel){
        Column(
            Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "GAME OVER",
                fontSize = 30.sp,
                color = IncorrectRed
            )
            Text(
                text = "You made it to the ${PresidentsList.elementAt(viewModel.CurrentPresident.value).positionString} president!",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = IncorrectRed
            )
//            Text(
//                text = "Your record is the 33rd president",
//                textAlign = TextAlign.Center,
//                fontSize = 30.sp,
//                color = IncorrectRed
//            )
            Text(
                text = "Try Again!",
                fontSize = 30.sp,
                color = IncorrectRed
            )
            Button(onClick = {
                viewModel.livesLeft.value = 3

                navController.navigate("new") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }) {
                Text(
                    text = "OKAY"
                )
            }
        }
}
