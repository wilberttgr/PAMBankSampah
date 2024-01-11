package com.example.pambanksampah.repositori

import android.content.Context
import com.example.pambanksampah.data.DatabaseSampah

interface ContainerApp {
    val repositori:Repositori
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositori:Repositori by lazy{
        OfflineRepositori(DatabaseSampah.getDatabase(context).pelaporDao())
    }
}