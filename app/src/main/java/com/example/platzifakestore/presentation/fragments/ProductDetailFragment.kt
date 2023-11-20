package com.example.platzifakestore.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.platzifakestore.databinding.FragmentProductDetailBinding
import com.example.platzifakestore.presentation.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment(), BaseFragment {

    private lateinit var binding: FragmentProductDetailBinding
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)

        initObservers()
        initUI()
        loadData()

        return binding.root
    }

    override fun initObservers() {
        viewModel.product.observe(viewLifecycleOwner) {
            binding.product = it
        }
    }

    override fun initUI() {
        // Empty
    }

    override fun loadData() {
        viewModel.getProduct()
    }

}