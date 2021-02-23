package ru.mmteams91.quest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Provides
import ru.mmteams91.dagger.PerFeature
import ru.mmteams91.presentation.viewModel.ViewModelFactory
import javax.inject.Provider

internal abstract class NavigationModule {

    @Provides
    @PerFeature
    fun viewModelFactory(
        viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory = ViewModelFactory(viewModels)
}