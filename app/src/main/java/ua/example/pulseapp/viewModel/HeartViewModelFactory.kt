package ua.example.pulseapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HeartViewModelFactory (private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeartViewModel::class.java)) {
            return HeartViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}