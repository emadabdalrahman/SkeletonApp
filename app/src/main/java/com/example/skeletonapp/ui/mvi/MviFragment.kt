package com.example.skeletonapp.ui.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.skeletonapp.ui.bind.BindFragment
import java.lang.reflect.ParameterizedType

abstract class MviFragment<Intent, ViewState, ViewModel : MviViewModel<Intent, ViewState>, T : ViewBinding> :
    BindFragment<T>() {

    private lateinit var vm: MviViewModel<Intent, ViewState>
    private val viewStateObserver: (ViewState) -> Unit = { render(it) }

    lateinit var intent: MutableLiveData<Intent>

    abstract fun render(viewState: ViewState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = viewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm.viewState.observe(viewLifecycleOwner, viewStateObserver)
        intent = vm.intent
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        vm.viewState.removeObserver(viewStateObserver)
        super.onDestroyView()
    }

    private fun viewModel(): MviViewModel<Intent, ViewState> {
        val parameterizedType = this::class.java.genericSuperclass as ParameterizedType
        val viewModelClass = parameterizedType.actualTypeArguments[2] as Class<ViewModel>
        return ViewModelProvider(this)[viewModelClass]
    }
}