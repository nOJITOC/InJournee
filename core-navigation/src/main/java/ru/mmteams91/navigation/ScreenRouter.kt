package ru.mmteams91.navigation

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.AppScreen
import com.github.terrakok.cicerone.androidx.Creator
import com.github.terrakok.cicerone.androidx.FragmentScreen

private const val MAX_REQUEST_CODE = 0x0000ffff
private const val START_REQUEST_CODE = MAX_REQUEST_CODE - 1_000
const val REQUEST_CODE_KEY = "requestCodeKey"

class ScreenRouter : Router(), IResultHandler {
    private var currentRequestCode = START_REQUEST_CODE

    override fun <T> startForResult(
        screen: AppScreen,
        clearContainer: Boolean,
        listener: IResultListener<T>
    ): ResultListenerHandler {
        val key = nextRequestCode()
        val handler = setResultListener(key.toString(), wrapListener(listener))
        val wrappedScreen: AppScreen = wrapScreen(screen, key)
        navigateTo(wrappedScreen, clearContainer)
        return handler
    }

    private fun wrapScreen(screen: AppScreen, key: Int): AppScreen = when (screen) {
        is FragmentScreen -> FragmentScreen(screen.screenKey) {
            val fragment = screen.createFragment(it)
            fragment.withArguments {
                putInt(REQUEST_CODE_KEY, key)
            }
        }
        is ActivityScreen -> screen

    }

    override fun onResult(key: Int, resultCode: Int, data: Any?) {
        sendResult(key.toString(), resultCode to data)
    }

    // todo move to utils
    fun Fragment.withArguments(function: Bundle.() -> Unit): Fragment {
        (arguments ?: Bundle().also { arguments = it }).run { function(this) }
        return this
    }

    private fun nextRequestCode(): Int {
        return if (currentRequestCode == MAX_REQUEST_CODE) {
            currentRequestCode = START_REQUEST_CODE
            currentRequestCode
        } else currentRequestCode++
    }

    private fun <T> wrapListener(listener: IResultListener<T>) =
        ResultListener { result ->
            val (code, data) = result as? Pair<*, *> ?: let {
                listener.onResult(Activity.RESULT_CANCELED, null)
                return@ResultListener
            }
            if (code is Int) {
                @Suppress("UNCHECKED_CAST")
                listener.onResult(code, data as? T)
            } else {
                listener.onResult(Activity.RESULT_CANCELED, null)
            }
        }
}