package com.example.skeletonapp.ui_data_binding.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import com.example.skeletonapp.ui_data_binding.bind.BindFragment
import com.example.skeletonapp.ui_view_bind.mvi.MviViewModel

abstract class MviFragment<Intent, ViewState, T: ViewDataBinding>() :
    BindFragment<T>() {

    val vm: MviViewModel<Intent, ViewState> by viewModels()
    private val viewStateObserver: (ViewState) -> Unit = { render(it) }

    abstract fun render(viewState: ViewState)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm.viewState.observe(viewLifecycleOwner, viewStateObserver)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        vm.viewState.removeObserver(viewStateObserver)
        super.onDestroyView()
    }
}