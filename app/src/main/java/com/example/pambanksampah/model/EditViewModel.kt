package com.example.pambanksampah.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pambanksampah.repositori.Repositori
import com.example.pambanksampah.ui.theme.halaman.ItemEditDestination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: Repositori
) : ViewModel() {

    var pelaporUiState by mutableStateOf(UIStatePelapor())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])
    //checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            pelaporUiState = repositoriSiswa.getpelaporStream(itemId)
                .filterNotNull()
                .first()
                .toUiStatePelapor(true)
        }
    }

    suspend fun updatePelapor() {
        if (validasiInput(pelaporUiState.detailPelapor)) {
            repositoriSiswa.updatepelapor(pelaporUiState.detailPelapor.toPelapor())
        }
        else {
            println("Data tidak valid")
        }
    }

    fun updateUiState(detailSiswa: DetailPelapor) {
        pelaporUiState =
            UIStatePelapor(detailPelapor = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }
    private fun validasiInput(uiState: DetailPelapor = pelaporUiState.detailPelapor ): Boolean {
        return with(uiState) {
            nama.isNotBlank()  && tangal_penjemputan.isNotBlank() && alamat.isNotBlank() && catatan.isNotBlank()
        }
    }
}