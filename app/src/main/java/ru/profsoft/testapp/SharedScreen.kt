package ru.profsoft.testapp

import cafe.adriel.voyager.core.registry.ScreenProvider

interface SharedScreen : ScreenProvider {
    object OrbitScreen : ScreenProvider
}