package com.example.platzifakestore.presentation.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.platzifakestore.R
import com.example.platzifakestore.databinding.ProductItemBinding
import com.example.platzifakestore.domain.models.Product
import com.squareup.picasso.Picasso

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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ProductItemBinding.bind(itemView)

        fun bind(product: Product) {
            binding.product = product
        }

        companion object {
            @BindingAdapter("imageUrls", "error")
            @JvmStatic
            fun loadImage(view: ImageView, urls: List<String>, errorDrawable: Drawable) {
                Picasso.get().load(urls.firstOrNull()).error(errorDrawable).into(view)
            }
        }
    }

}