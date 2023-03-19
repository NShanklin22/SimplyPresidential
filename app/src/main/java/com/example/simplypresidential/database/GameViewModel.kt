package com.example.simplypresidential.database

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val gameDataRepository: GameDataRepository) :
    ViewModel() {

    val employeeList: LiveData<List<GameData>> = gameDataRepository.allGames

    val foundEmployee: LiveData<GameData> = gameDataRepository.foundGame

    fun addEmployee(gameData: GameData) {
        gameDataRepository.addGameData(gameData)
    }

    fun updateEmployeeDetails(gameData: GameData) {
        gameDataRepository.updateGameData(gameData)
    }

    val CurrentPresident = mutableStateOf(0)

    val livesLeft = mutableStateOf(3)

    // Using into to store 3 states, 0 = null, 1 = Incorrect, 2 = Correct
    val isCorrect = mutableStateOf(0)

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