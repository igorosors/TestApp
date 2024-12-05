package ru.profsoft.testapp

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import dagger.hilt.android.HiltAndroidApp
import ru.profsoft.testapp.orbit.OrbitScreen

@HiltAndroidApp
class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            register<SharedScreen.OrbitScreen> { OrbitScreen() }
        }
    }
}