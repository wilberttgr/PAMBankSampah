package com.example.banksampah

import android.app.Application
import com.example.banksampah.repositori.ContainerApp
import com.example.banksampah.repositori.ContainerDataApp

class AplikasiBankSampah : Application() {
    lateinit var container: ContainerApp
    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}