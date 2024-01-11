package com.example.banksampah.repositori

import com.example.banksampah.data.Pelapor
import kotlinx.coroutines.flow.Flow

interface Repositori {
    fun getAllpelaporStream(): Flow<List<Pelapor>>

    fun getpelaporStream(id: Int): Flow<Pelapor?>

    suspend fun insertpelapor(pelapor: Pelapor)

    suspend fun deletepelapor(pelapor: Pelapor)

    suspend fun updatepelapor(pelapor: Pelapor)
}