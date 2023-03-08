package com.example.simplypresidential.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class GameData(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "runId")
    var runId: Int,

    @ColumnInfo(name = "maxPresident")
    var maxPresident: Int

)