package com.example.pambanksampah.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pelapor")
data class Pelapor(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val tangal_penjemputan : String,
    val alamat : String,
    val catatan : String,
    val berat : Int,
    val total_harga: Int
)