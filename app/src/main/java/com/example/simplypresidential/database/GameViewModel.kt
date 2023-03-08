package com.example.simplypresidential.database

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

}