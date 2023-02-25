package com.example.simplypresidential.database

import androidx.annotation.DrawableRes
import com.example.simplypresidential.R

data class PresidentData(
    @DrawableRes val image: Int,
    val FirstName: String,
    val LastName: String,
    val StartDate: String,
    val EndDate: String,
)

val PresidentsList = listOf(
    PresidentData(
        R.drawable.pres01,
        "George",
        "Washington",
        "1789",
        "1797"
    ),
    PresidentData(
        R.drawable.pres02,
        "John",
        "Adams",
        "1797",
        "1801"
    ),
)