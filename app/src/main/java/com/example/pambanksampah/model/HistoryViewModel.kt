package com.example.pambanksampah.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pambanksampah.data.Pelapor
import com.example.pambanksampah.repositori.Repositori
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HistoryViewModel(private val repositoriPelapor: Repositori) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val historyUiState: StateFlow<HomeUiState> = repositoriPelapor.getAllpelaporStream().filterNotNull()
        .map { HomeUiState(listPelapor = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    data class HomeUiState(
        val listPelapor: List<Pelapor> = listOf()
    )

}