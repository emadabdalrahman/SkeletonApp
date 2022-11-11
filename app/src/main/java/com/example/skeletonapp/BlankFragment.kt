package com.example.skeletonapp

import com.example.skeletonapp.databinding.FragmentBlankBinding
import com.example.skeletonapp.ui_view_bind.bind.BindFragment

class BlankFragment : BindFragment<FragmentBlankBinding>() {

    override fun bindClass() = FragmentBlankBinding::class.java

}