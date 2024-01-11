package com.example.pambanksampah.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pambanksampah.AplikasiBankSampah

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HistoryViewModel(aplikasiSampah().container.repositori) }
        initializer {
            InputViewModel(aplikasiSampah().container.repositori)
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSampah().container.repositori,
            )
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                aplikasiSampah().container.repositori,
            )
        }
    }

    fun CreationExtras.aplikasiSampah(): AplikasiBankSampah =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiBankSampah)
}