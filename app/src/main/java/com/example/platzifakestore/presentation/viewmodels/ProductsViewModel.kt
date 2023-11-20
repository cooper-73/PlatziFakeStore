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

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    fun getAllProducts() {
        viewModelScope.launch {
            val products = withContext(Dispatchers.IO) {
                productsUseCase.getAllProducts()
            }

            _products.postValue(products)
        }
    }

    fun getProduct(productId: Int) {
        viewModelScope.launch {
            val product = withContext(Dispatchers.IO) {
                productsUseCase.getProduct(productId)
            }

            _product.postValue(product)
        }
    }
}