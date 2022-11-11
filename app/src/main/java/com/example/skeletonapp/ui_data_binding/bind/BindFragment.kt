package com.example.skeletonapp.ui_data_binding.bind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

//for date binding
abstract class BindFragment<T : ViewDataBinding> :Fragment() {

    private var weakBind: WeakReference<T> = WeakReference(null)

    abstract fun getLayoutId():Int

    fun bind(): T {
        if (weakBind.get() == null) throw Exception("you can use bind after onCreateView been called")
        return weakBind.get() as T
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)
        weakBind = WeakReference(bind)
        return bind?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        weakBind.get()?.unbind()
        weakBind.clear()
    }
}
