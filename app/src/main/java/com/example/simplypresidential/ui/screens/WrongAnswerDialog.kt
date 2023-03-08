package com.example.simplypresidential.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.database.PresidentsList
import com.example.simplypresidential.ui.theme.IncorrectRed

@Composable
fun WrongAnswerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    viewModel: PresidentViewModel
){
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth(fraction = .95f),
        ){

            val firstName = PresidentsList.elementAt(viewModel.CurrentPresident.value).FirstName
            val lastName = PresidentsList.elementAt(viewModel.CurrentPresident.value).LastName
            val startDate = PresidentsList.elementAt(viewModel.CurrentPresident.value).StartDate
            val endDate = PresidentsList.elementAt(viewModel.CurrentPresident.value).EndDate
            val positionString = PresidentsList.elementAt(viewModel.CurrentPresident.value).positionString

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "INCORRECT",
                    fontSize = 30.sp,
                    color = IncorrectRed
                )
                Text(
                    text = "$firstName $lastName was the $positionString president of the United States and served from $startDate to $endDate",
                    fontSize = 30.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
                Button(onClick = {
                    viewModel.isCorrect.value = 0
                    if(viewModel.livesLeft.value == 0){

                    }else{
                        viewModel.livesLeft.value -= 1
                    }
                }) {
                    Text(
                        text = "Heck"
                    )
                }
            }
        }
    }

}