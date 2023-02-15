package com.example.simplypresidential.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplypresidential.R


@Composable
fun GameScreen(){
    // All widgets will sit under the modifier screen
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        GameStatus()

        PresidentDisplay()

        UserInput()
    }
}

@Composable
fun GameStatus(

){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,


    ) {
        Text(text = "1 of 50")

        Text(text = "Heart 3")
    }
}

@Composable
fun PresidentDisplay(){
    Text(
        text = "1st President of the United States",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    Image(
        painter = painterResource(id = R.drawable.pres01),
        contentDescription = "George Washington"
    )
}

@Composable
fun UserInput(){
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .border(
//                BorderStroke(2.dp, SolidColor(Color.Red))
//            )
                ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Answer",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){

            var firstName by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .width(150.dp),
                value = firstName, onValueChange = { textEntry -> firstName = textEntry},
                placeholder = { Text(text = "First Name")}
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .width(150.dp),
                value = lastName,
                onValueChange = {textEntry -> lastName = textEntry},
                placeholder = { Text(text = "Last Name")}
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){

            var startDate by remember { mutableStateOf("") }
            var endDate by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .width(150.dp),
                value = startDate, onValueChange = {textEntry -> startDate = textEntry},
                placeholder = { Text(text = "Start Year")}
            )
            Text(text = "TO")
            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .width(150.dp),
                value = endDate,
                onValueChange = {textEntry -> endDate = textEntry},
                placeholder = { Text(text = "End Year")}
            )
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .width(250.dp),
            onClick = {}
        ) {
            Text(text = "Submit")
        }
    }
}
