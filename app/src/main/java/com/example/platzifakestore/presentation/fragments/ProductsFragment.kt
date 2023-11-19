package com.example.platzifakestore.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.platzifakestore.databinding.FragmentProductsBinding

class ProductsFragment : Fragment(), BaseFragment {

    private lateinit var binding: FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun bindViewModel() {
        // Empty
    }

    override fun initObservers() {
        // Empty
    }

    override fun initUI() {
        // Empty
    }

    override fun loadData() {
        // Empty
    }

}