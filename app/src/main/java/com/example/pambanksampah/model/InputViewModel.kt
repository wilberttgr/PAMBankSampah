package com.example.pambanksampah.model

import com.example.pambanksampah.data.Pelapor

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