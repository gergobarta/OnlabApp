package com.example.onlabapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

import com.example.onlabapp.R
import com.example.onlabapp.data.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: ArrayList<Product>): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
       // val product=products[position]
      //  Picasso.get().load(products[position].photoUrl).into(holder.image)
        holder.title.text=products[position].title
       // holder.price.text=product.price.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount()=products.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView=itemView.findViewById(R.id.image)
        val title: TextView =itemView.findViewById(R.id.title)
        val price: TextView =itemView.findViewById(R.id.price)
    }

}