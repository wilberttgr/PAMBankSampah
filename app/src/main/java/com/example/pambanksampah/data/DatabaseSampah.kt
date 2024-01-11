package com.example.pambanksampah.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pelapor::class],version = 1, exportSchema = false)
abstract class DatabaseSampah : RoomDatabase(){
    abstract fun pelaporDao() : PelaporDao

    companion object{
        @Volatile
        private var Instance: DatabaseSampah? = null

        fun getDatabase(context: Context): DatabaseSampah{
            return (Instance?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabaseSampah::class.java,"sampah_database")
                    .build().also { Instance = it }
            })
        }
    }
}