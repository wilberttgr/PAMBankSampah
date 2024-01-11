package com.example.banksampah.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.banksampah.data.Pelapor
import com.example.banksampah.repositori.Repositori


class InputViewModel(private val repositori: Repositori) : ViewModel() {

    /*
       *Berisi status Siswa saat ini
        */
    var uiStatePelapor by mutableStateOf(UIStatePelapor())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailPelapor = uiStatePelapor.detailPelapor): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && tangal_penjemputan.isNotBlank()&& catatan.isNotBlank()
        }
    }

    fun updateUiState(detailPelapor: DetailPelapor) {
        uiStatePelapor =
            UIStatePelapor(detailPelapor = detailPelapor, isEntryValid = validasiInput(detailPelapor))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun savePelapor() {
        if (validasiInput()) {
            repositori.insertpelapor(uiStatePelapor.detailPelapor.toPelapor())
        }
    }
}

data class DetailPelapor(
    val id : Int = 0,
    val nama : String = "",
    val tangal_penjemputan : String = "",
    val alamat : String = "",
    val catatan : String = "",
    val berat : Int = 0,
    val total_harga: Int = 0
)

data class UIStatePelapor(
    val detailPelapor: DetailPelapor= DetailPelapor(),
    val isEntryValid: Boolean = false
)

fun DetailPelapor.toPelapor(): Pelapor = Pelapor(
    id = id,
    nama = nama,
    tangal_penjemputan = tangal_penjemputan,
    alamat = alamat,
    catatan = catatan,
    berat = berat,
    total_harga = total_harga
)

fun Pelapor.toUiStatePelapor(isEntryValid: Boolean = false): UIStatePelapor = UIStatePelapor(
    detailPelapor = this.toDetailPelapor(),
    isEntryValid = isEntryValid
)
fun Pelapor.toDetailPelapor(): DetailPelapor= DetailPelapor(
    id = id,
    nama = nama,
    tangal_penjemputan = tangal_penjemputan,
    alamat = alamat,
    catatan = catatan,
    berat = berat,
    total_harga = total_harga
)