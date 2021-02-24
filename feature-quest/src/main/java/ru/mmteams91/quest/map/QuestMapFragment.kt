package ru.mmteams91.quest.map

import android.opengl.GLSurfaceView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch
import ru.mmteams91.presentation.view.ScreenFragment
import ru.mmteams91.quest.databinding.QuestMapFragmentBinding

internal class QuestMapFragment : ScreenFragment<QuestMapViewModel>(QuestMapViewModel::class.java) {

    lateinit var binding: QuestMapFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuestMapFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}