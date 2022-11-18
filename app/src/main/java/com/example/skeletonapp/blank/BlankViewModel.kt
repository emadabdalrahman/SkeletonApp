package com.example.skeletonapp.blank

import com.example.skeletonapp.ui.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BlankViewModel @Inject constructor() : MviViewModel<BlankIntent, BlankViewState>() {
    override suspend fun process(intent: BlankIntent) {
        TODO("Not yet implemented")
    }
}