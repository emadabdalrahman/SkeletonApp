package com.example.skeletonapp.ui_view_bind.bind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.ref.WeakReference

// for view binding
abstract class BindFragment<T : ViewBinding> : Fragment() {

    private var weakBind: WeakReference<T> = WeakReference(null)

    abstract fun bindClass(): Class<T>

    fun bind(): T {
        if (weakBind.get() == null) throw Exception("you can use bind after onCreateView been called")
        return weakBind.get() as T
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = bindClass().getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null,inflater, container, false) as T?
        weakBind = WeakReference(bind)
        return bind?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        weakBind.clear()
    }
}
