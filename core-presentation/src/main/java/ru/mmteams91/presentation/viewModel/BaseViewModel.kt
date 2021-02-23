package ru.mmteams91.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.androidx.AppScreen
import ru.mmteams91.navigation.IResultHandler
import ru.mmteams91.navigation.IResultListener
import ru.mmteams91.navigation.ScreenRouter
import javax.inject.Inject

abstract class BaseViewModel : ViewModel(), IResultHandler {
    @Inject
    protected lateinit var router: ScreenRouter

    override fun <T> startForResult(
        screen: AppScreen,
        clearContainer: Boolean,
        listener: IResultListener<T>
    ): ResultListenerHandler {
        return router.startForResult(screen, clearContainer, listener)
    }

    override fun onResult(key: Int, resultCode: Int, data: Any?) {
        router.onResult(key, resultCode, data)
    }
}