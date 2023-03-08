package com.example.simplypresidential.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.simplypresidential.database.PresidentViewModel
import com.example.simplypresidential.ui.theme.CorrectGreen
import com.example.simplypresidential.ui.theme.IncorrectRed

@Composable
fun RightAnswerDialog(
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
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "CORRECT",
                    fontSize = 30.sp,
                    color = CorrectGreen
                )
                // On button press increment the current president unless we are on the last president
                Button(onClick = {
                    viewModel.isCorrect.value = 0
                    if(viewModel.CurrentPresident.value < 45){
                        viewModel.CurrentPresident.value += 1
                    }
                }) {
                    Text(
                        text = "Nice"
                    )
                }
            }
        }
    }

}