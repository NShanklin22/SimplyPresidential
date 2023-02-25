package com.example.simplypresidential.database

data class GameUiState(
    val currentPresident: Int = 1,
    val lifeCount: Int = 3,
    val isGuessCorrect: Boolean = false,
    val isGameOver: Boolean = false
)
