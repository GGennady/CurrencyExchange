package com.example.currencyexchange.screens.cash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.R
import com.example.currencyexchange.databinding.FragmentCashBinding
import com.example.currencyexchange.databinding.FragmentRootBinding

class CashFragment : Fragment() {

    private var _binding: FragmentCashBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for FragmentCash must be not null.")

    //private val cashAdapter = CashAdapter()
    private lateinit var cashAdapter: CashAdapter
    private val viewModel: CashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()
        viewModel.fetchCash()
    }

    private fun setupRecyclerView() {
        cashAdapter = CashAdapter()
        binding.rvCash.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cashAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.cashList.observe(viewLifecycleOwner, Observer { list -> cashAdapter.setList(list)})
        // viewModel.cashError.observe(viewLifecycleOwner, Observer { })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}