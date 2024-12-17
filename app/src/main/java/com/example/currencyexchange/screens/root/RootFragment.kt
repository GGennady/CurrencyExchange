package com.example.currencyexchange.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.currencyexchange.R
import com.example.currencyexchange.ViewPagerAdapter
import com.example.currencyexchange.databinding.FragmentRootBinding

class RootFragment : Fragment() {

    private var context: Context ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    private var _binding: FragmentRootBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for FragmentRoot must be not null.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRootBinding.inflate(layoutInflater, container, false)
        binding.viewPager.adapter = ViewPagerAdapter(context as FragmentActivity)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}