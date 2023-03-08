package com.example.simplypresidential.database

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameDataRepository(private val gameDAO: GameDataDAO) {

    val allGames = MutableLiveData<List<GameData>>()
    val foundGame = MutableLiveData<GameData>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addGameData(newGameData: GameData) {
        coroutineScope.launch(Dispatchers.IO) {
            gameDAO.addGameData(newGameData)
        }
    }

    fun updateGameData(newGameData: GameData) {
        coroutineScope.launch(Dispatchers.IO) {
            gameDAO.updateGameDetails(newGameData)
        }
    }
}