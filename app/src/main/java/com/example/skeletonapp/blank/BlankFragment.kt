package com.example.skeletonapp.blank

import com.example.skeletonapp.databinding.FragmentBlankBinding
import com.example.skeletonapp.ui.mvi.MviFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlankFragment :
    MviFragment<BlankIntent, BlankViewState, BlankViewModel, FragmentBlankBinding>() {

    override fun render(viewState: BlankViewState) {
    }

}