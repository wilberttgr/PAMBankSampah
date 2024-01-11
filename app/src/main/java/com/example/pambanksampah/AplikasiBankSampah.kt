package com.example.pambanksampah

import android.app.Application
import com.example.pambanksampah.repositori.ContainerApp
import com.example.pambanksampah.repositori.ContainerDataApp

class AplikasiBankSampah : Application() {
    lateinit var container: ContainerApp
    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}