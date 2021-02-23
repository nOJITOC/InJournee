package ru.mmteams91.quest.choose

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import ru.mmteams91.presentation.view.ScreenFragment

class ChooseQuestFragment : ScreenFragment<ChooseQuestViewModel>(ChooseQuestViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}