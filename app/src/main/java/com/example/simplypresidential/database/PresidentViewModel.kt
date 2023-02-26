package com.example.simplypresidential.database

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PresidentViewModel() : ViewModel() {

    val CurrentPresident = mutableStateOf(0)

    val livesLeft = mutableStateOf(3)

    val isCorrect = mutableStateOf(false)

    fun checkFirstName(firstName:String): Boolean {
        if(firstName == PresidentsList.elementAt(CurrentPresident.value).FirstName){
            return true
        }else{
            return false
        }
    }

    fun checkLastName(lastName:String): Boolean {
        if(lastName == PresidentsList.elementAt(CurrentPresident.value).LastName){
            return true
        }else{
            return false
        }
    }

    fun checkStartDate(startDate:String): Boolean {
        if(startDate == PresidentsList.elementAt(CurrentPresident.value).StartDate){
            return true
        }else{
            return false
        }
    }

    fun checkEndDate(endDate:String): Boolean {
        if(endDate == PresidentsList.elementAt(CurrentPresident.value).EndDate){
            return true
        }else{
            return false
        }
    }

}