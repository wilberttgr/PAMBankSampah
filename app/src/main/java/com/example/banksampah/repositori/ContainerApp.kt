package com.example.banksampah.repositori

import android.content.Context
import com.example.banksampah.data.DatabaseSampah

interface ContainerApp {
    val repositori:Repositori
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositori:Repositori by lazy{
        OfflineRepositori(DatabaseSampah.getDatabase(context).pelaporDao())
    }
}