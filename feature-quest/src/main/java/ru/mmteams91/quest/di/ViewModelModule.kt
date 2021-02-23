package ru.mmteams91.quest.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.mmteams91.presentation.viewModel.ViewModelKey
import ru.mmteams91.quest.choose.ChooseQuestViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChooseQuestViewModel::class)
    fun chooseQuestViewModel(viewModel: ChooseQuestViewModel): ViewModel

}