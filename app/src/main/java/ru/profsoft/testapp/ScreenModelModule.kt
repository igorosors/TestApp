package ru.profsoft.testapp

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import ru.profsoft.testapp.orbit.OrbitScreenModel

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(OrbitScreenModel::class)
    abstract fun bindOrbitScreenModel(orbitScreenModel: OrbitScreenModel): ScreenModel
}
