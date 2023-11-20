package com.example.platzifakestore.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platzifakestore.databinding.FragmentProductsBinding
import com.example.platzifakestore.presentation.adapters.ProductAdapter
import com.example.platzifakestore.presentation.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(), BaseFragment, ProductAdapter.Listener {

    private lateinit var binding: FragmentProductsBinding
    private val viewModel: ProductsViewModel by viewModels()
    private val adapter = ProductAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)

        initObservers()
        initUI()
        loadData()

        return binding.root
    }

    override fun initObservers() {
        viewModel.products.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun initUI() {
        binding.rvProductsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvProductsList.adapter = adapter
    }

    override fun loadData() {
        viewModel.getAllProducts()
    }

    override fun onProductClick(id: Int) {
        findNavController().navigate(
            ProductsFragmentDirections.actionProductsFragmentToProductDetailFragment(
                productId = id
            )
        )
    }

}