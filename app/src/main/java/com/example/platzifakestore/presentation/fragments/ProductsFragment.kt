package com.example.platzifakestore.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platzifakestore.databinding.FragmentProductsBinding
import com.example.platzifakestore.presentation.adapters.ProductAdapter

class ProductsFragment : Fragment(), BaseFragment {

    private lateinit var binding: FragmentProductsBinding
    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)

        bindViewModel()
        initObservers()
        initUI()
        loadData()

        return binding.root
    }

    override fun bindViewModel() {
        // Empty
    }

    override fun initObservers() {
        // Empty
    }

    override fun initUI() {
        binding.rvProductsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvProductsList.adapter = adapter
    }

    override fun loadData() {
        // Empty
    }

}