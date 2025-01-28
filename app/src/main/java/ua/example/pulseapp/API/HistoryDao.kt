package ua.example.pulseapp.API

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ua.example.pulseapp.models.HistoryResult

@Dao
interface HistoryDao {
    @Query("Delete from `history-table`")
    suspend fun delete()

    @Insert
    suspend fun insert(historyEntity: HistoryResult)

    @Query("Select * from `history-table`")
    suspend fun fetchAll():List<HistoryResult>
}