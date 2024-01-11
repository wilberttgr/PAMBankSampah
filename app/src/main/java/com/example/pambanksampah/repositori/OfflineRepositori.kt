package com.example.pambanksampah.repositori

import com.example.pambanksampah.data.Pelapor
import com.example.pambanksampah.data.PelaporDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositori(private val pelaporDao: PelaporDao) : Repositori {
    override fun getAllpelaporStream(): Flow<List<Pelapor>> = pelaporDao.getAllpelapor()


    override fun getpelaporStream(id: Int): Flow<Pelapor?> = pelaporDao.getpelapor(id)


    override suspend fun insertpelapor(pelapor: Pelapor)=pelaporDao.insert(pelapor)

    override suspend fun deletepelapor(pelapor: Pelapor) = pelaporDao.delete(pelapor)

    override suspend fun updatepelapor(pelapor: Pelapor) = pelaporDao.update(pelapor)
}