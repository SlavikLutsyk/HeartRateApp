package ua.example.pulseapp.viewModel

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.example.pulseapp.API.HistoryDB
import ua.example.pulseapp.models.HistoryResult

class HeartViewModel(private val context: Context): ViewModel() {

    val historyState = mutableStateOf(HistoryState())
        get() = field


    private val historyDao by lazy {
        HistoryDB.getInstance(context).historyDao()
    }

    init {
        getHistory()
    }

    private fun getHistory(){
        viewModelScope.launch {
            try {
                val response = historyDao.fetchAll()
                historyState.value=historyState.value.copy(
                    loading = false,
                    list = response,
                    error = null
                )
            }
            catch (e:Exception){
                historyState.value=historyState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }

    public fun deleteHistory(): MutableState<HistoryState>{
        val deleteState = mutableStateOf(HistoryState())
        viewModelScope.launch {
            try {
                historyDao.delete()
                deleteState.value = deleteState.value.copy(
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                deleteState.value = deleteState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
        return deleteState
    }

    public fun insertRecord(record: HistoryResult): MutableState<HistoryState>{
        val insertState = mutableStateOf(HistoryState())
        viewModelScope.launch {
            try {
                historyDao.insert(record)
                insertState.value = insertState.value.copy(
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                insertState.value = insertState.value.copy(
                    loading = false,
                    error = null
                )
            }
        }
        return insertState
    }

    data class HistoryState(
        val loading: Boolean = true,
        val list: List<HistoryResult> = emptyList(),
        val error: String? = null
    )
}