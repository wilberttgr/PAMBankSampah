package com.example.pambanksampah.repositori

import com.example.pambanksampah.data.Pelapor
import kotlinx.coroutines.flow.Flow

interface Repositori {
    fun getAllpelaporStream(): Flow<List<Pelapor>>

    fun getpelaporStream(id: Int): Flow<Pelapor?>

    suspend fun insertpelapor(pelapor: Pelapor)

    suspend fun deletepelapor(pelapor: Pelapor)

    suspend fun updatepelapor(pelapor: Pelapor)
}