package com.example.skeletonapp.ui_data_binding.mvi

import androidx.lifecycle.*
import kotlinx.coroutines.launch

@Suppress("PropertyName")
abstract class MviViewModel<Intent, ViewState> : ViewModel() {

    private val intentObserver = Observer<Intent> {
        viewModelScope.launch {
            process(it)
        }
    }
    protected val _viewState: MutableLiveData<ViewState> = MutableLiveData()

    val viewState: LiveData<ViewState> = _viewState
    val intent: MutableLiveData<Intent> = MutableLiveData()

    protected abstract suspend fun process(intent: Intent)

    init {
        intent.observeForever(intentObserver)
    }

    override fun onCleared() {
        super.onCleared()
        intent.removeObserver(intentObserver)
    }

}