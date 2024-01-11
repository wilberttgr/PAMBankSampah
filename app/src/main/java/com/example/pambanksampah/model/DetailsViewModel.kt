package com.example.pambanksampah.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pambanksampah.repositori.Repositori
import com.example.pambanksampah.ui.theme.halaman.DetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositori: Repositori
) : ViewModel(){
    private val pelaporId: Int = checkNotNull(savedStateHandle[DetailsDestination.pelaporIdArg])
    val uiState: StateFlow<ItemDetailsUiState> =
        repositori.getpelaporStream(pelaporId)
            .filterNotNull()
            .map {
                ItemDetailsUiState(detailPelapor = it.toDetailPelapor())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailsUiState(detailPelapor = DetailPelapor())
            )
    suspend fun deleteItem(){
        repositori.deletepelapor(uiState.value.detailPelapor.toPelapor())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val detailPelapor: DetailPelapor
)