package com.example.pambanksampah.model

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