package com.example.banksampah.repositori

import com.example.banksampah.data.Pelapor
import com.example.banksampah.data.PelaporDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositori(private val pelaporDao: PelaporDao) : Repositori {
    override fun getAllpelaporStream(): Flow<List<Pelapor>> = pelaporDao.getAllpelapor()


    override fun getpelaporStream(id: Int): Flow<Pelapor?> = pelaporDao.getpelapor(id)


    override suspend fun insertpelapor(pelapor: Pelapor)=pelaporDao.insert(pelapor)

    override suspend fun deletepelapor(pelapor: Pelapor) = pelaporDao.delete(pelapor)

    override suspend fun updatepelapor(pelapor: Pelapor) = pelaporDao.update(pelapor)
}