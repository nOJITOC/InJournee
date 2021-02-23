package ru.mmteams91.presentation.view

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ru.mmteams91.presentation.viewModel.BaseViewModel
import ru.mmteams91.presentation.viewModel.ViewModelFactory
import javax.inject.Inject

abstract class ScreenFragment<VM : BaseViewModel>(
    viewModelClass: Class<VM>,
    @LayoutRes layoutRes: Int = 0
) : Fragment(layoutRes) {

    protected val viewModel: VM by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[viewModelClass]
    }
    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            subscribeToEvents()
        }
    }

    open suspend fun subscribeToEvents() = Unit
}