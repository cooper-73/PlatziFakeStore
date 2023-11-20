package com.example.platzifakestore.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzifakestore.domain.models.Product
import com.example.platzifakestore.domain.usecases.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _filteredProducts = MutableLiveData<List<Product>>()
    val filteredProducts: LiveData<List<Product>> = _filteredProducts

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            val products = withContext(Dispatchers.IO) {
                productsUseCase.getAllProducts()
            }

            _products.postValue(products)
        }
    }

    fun filterProductsByTitle(title: String) {
        viewModelScope.launch {
            val filterdProducts = withContext(Dispatchers.IO) {
                productsUseCase.filterProductsByTitle(title)
            }

            _filteredProducts.postValue(filterdProducts)
        }
    }

    fun sortProductsByPrice(isAsc: Boolean) {
        viewModelScope.launch {
            val sortedProducts = withContext(Dispatchers.IO) {
                productsUseCase.getProductsSortedByPrice(isAsc)
            }

            _products.postValue(sortedProducts)
        }
    }
}