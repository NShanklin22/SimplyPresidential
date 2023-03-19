package com.example.simplypresidential.database

import androidx.room.*
import com.example.simplypresidential.ui.navigation.NavRoutes

@Dao
interface GameDataDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGameData(GameData: GameData)

    @Query("SELECT * FROM GameData WHERE runId = :runId")
    fun findGameDataByRunId(runId: String): GameData

    @Query("SELECT * FROM gamedata")
    fun getAllGames(): List<GameData>

    @Update
    suspend fun updateGameDetails(gameData: GameData)

    @Delete
    suspend fun deleteEmployee(gameData: GameData)

}