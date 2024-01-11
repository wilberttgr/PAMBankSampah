package com.example.banksampah.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PelaporDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pelapor: Pelapor)

    @Update
    suspend fun update(pelapor: Pelapor)

    @Delete
    suspend fun delete(pelapor: Pelapor)

    @Query("SELECT * from Pelapor WHERE id = :id")
    fun getpelapor(id: Int): Flow<Pelapor>

    @Query("SELECT * from Pelapor ORDER BY nama ASC")
    fun getAllpelapor(): Flow<List<Pelapor>>
}