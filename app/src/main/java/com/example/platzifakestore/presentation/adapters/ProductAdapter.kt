package com.example.platzifakestore.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platzifakestore.R
import com.example.platzifakestore.databinding.ProductItemBinding
import com.example.platzifakestore.domain.models.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var productsList: List<Product> = emptyList()

    fun updateData(products: List<Product>) {
        productsList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ProductItemBinding.bind(itemView)

        fun bind(product: Product) {
            binding.product = product
        }
    }

}