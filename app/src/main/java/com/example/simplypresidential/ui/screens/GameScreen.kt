package com.example.simplypresidential.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.simplypresidential.R
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.database.PresidentsList
import kotlinx.coroutines.launch


@Composable
fun GameScreen(viewModel: PresidentViewModel, navController: NavController){

    LaunchedEffect(viewModel.livesLeft.value == 0) {
        if(viewModel.livesLeft.value == 0) {
            navController.navigate("GameOver") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

            }
        }
    }

    LaunchedEffect(viewModel.livesLeft.value > 0 && viewModel.CurrentPresident.value > 45) {
        if(viewModel.livesLeft.value > 0 && viewModel.CurrentPresident.value > 45) {
            navController.navigate("victory") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
            }
        }
    }

    // All widgets will sit under the modifier screen
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        GameStatus(viewModel)

        PresidentDisplay(viewModel)

        UserInput(viewModel)

        AdvertView()
    }
}

@Composable
fun GameStatus(
    viewModel: PresidentViewModel
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Text(
            text = "${viewModel.CurrentPresident.value+1} of 45",
            Modifier.padding(horizontal = 5.dp)
        )

        Row(){
            for(i in 1..viewModel.livesLeft.value){
                Image(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = "heart"
                )
            }
        }
    }
}

@Composable
fun PresidentDisplay(
    viewModel: PresidentViewModel
){
    Text(
        text = "${PresidentsList.elementAt(viewModel.CurrentPresident.value).positionString} President of the United States",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    Image(
        painter = painterResource(PresidentsList.elementAt(viewModel.CurrentPresident.value).image),
        contentDescription = "president"
    )
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun UserInput(
    viewModel: PresidentViewModel
){

    // Display if the user submits a correct answer
    if (viewModel.isCorrect.value == 2){
        RightAnswerDialog(
            viewModel = viewModel,
            onConfirm = {},
            onDismiss = {}
        )
    }

    // Display if the user submits an incorrect answer
    if (viewModel.isCorrect.value == 1){
        WrongAnswerDialog(
            viewModel = viewModel,
            onConfirm = {},
            onDismiss = {}
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        val context = LocalContext.current

        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var startDate by remember { mutableStateOf("") }
        var endDate by remember { mutableStateOf("") }

        var firstNameError by remember { mutableStateOf(0) }
        var lastNameError by remember { mutableStateOf(0) }
        var startDateError by remember { mutableStateOf(0) }
        var endDateError by remember { mutableStateOf(0) }

        Text(
            text = "Answer",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            OutlinedTextField(
                singleLine = true,
                modifier = Modifier
                    .padding(5.dp)
                    .width(150.dp),
                value = firstName, onValueChange = {
                        textEntry -> firstName = textEntry
                       },
                placeholder = { Text(text = "First Name")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(firstNameError == 1){Color.Red}else if(firstNameError == 0){Color.Gray}else{Color.Green} ,
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    })
            )
            Text(text = "TO", color = Color.White)
            OutlinedTextField(
                singleLine = true,
                modifier = Modifier
                    .padding(5.dp)
                    .width(150.dp),
                value = lastName,
                onValueChange = {textEntry -> lastName = textEntry},
                placeholder = { Text(text = "Last Name")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(lastNameError == 1){Color.Red}else if(lastNameError == 0){Color.Gray}else{Color.Green} ,
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    })
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            OutlinedTextField(
                singleLine = true,
                modifier = Modifier
                    .padding(5.dp)
                    .width(150.dp),
                value = startDate, onValueChange = {textEntry -> startDate = textEntry},
                placeholder = { Text(text = "Start Year")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(startDateError == 1){Color.Red}else if(startDateError == 0){Color.Gray}else{Color.Green},
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done,keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    })
            )
            Text(text = "TO")
            OutlinedTextField(
                singleLine = true,
                modifier = Modifier
                    .padding(5.dp)
                    .width(150.dp),
                value = endDate,
                onValueChange = {textEntry -> endDate = textEntry},
                placeholder = { Text(text = "End Year")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(endDateError == 1){Color.Red}else if(endDateError == 0){Color.Gray}else{Color.Green} ,
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    })
            )
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .width(250.dp),
            onClick = {
                if(viewModel.checkFirstName(firstName)){
                    firstNameError = 2
                }else{
                    firstNameError = 1
                    firstName = ""
                }

                if(viewModel.checkLastName(lastName)){
                    lastNameError = 2
                }else{
                    lastNameError = 1
                    lastName = ""
                }

                if(viewModel.checkStartDate(startDate)){
                    startDateError = 2
                }else{
                    startDateError = 1
                    startDate = ""
                }

                if(viewModel.checkEndDate(endDate)){
                    endDateError = 2
                }else{
                    endDateError = 1
                    endDate = ""
                }

                if(firstNameError == 2 && lastNameError == 2 && startDateError == 2 && endDateError == 2){
                    Log.d("Heck yeah","Heck yeah")
                    viewModel.isCorrect.value = 2
                    firstName = ""
                    lastName = ""
                    startDate = ""
                    endDate = ""
                    firstNameError = 0
                    lastNameError = 0
                    startDateError = 0
                    endDateError = 0
                }else{
                    viewModel.isCorrect.value = 1
                }
            }
        ) {
            Text(text = "Submit")
        }
        AdvertView()
    }
}
