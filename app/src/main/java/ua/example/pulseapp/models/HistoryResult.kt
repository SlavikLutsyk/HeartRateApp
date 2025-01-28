package ua.example.pulseapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class HistoryResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val pulse: Int,
    val time: String
)
