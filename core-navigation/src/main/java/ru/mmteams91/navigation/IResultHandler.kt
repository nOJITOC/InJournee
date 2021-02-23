package ru.mmteams91.navigation

import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.androidx.AppScreen

interface IResultHandler {

    fun <T> startForResult(
        screen: AppScreen,
        clearContainer: Boolean = true,
        listener: IResultListener<T>
    ): ResultListenerHandler

    fun <T> startForResult(
        screen: AppScreen,
        clearContainer: Boolean = true,
        listener: (code: Int, data: T?) -> Unit
    ) = startForResult(screen, clearContainer, object : IResultListener<T> {
        override fun onResult(resultCode: Int, data: T?) {
            listener(resultCode, data)
        }
    })

    fun onResult(key: Int, resultCode: Int, data: Any?)
}