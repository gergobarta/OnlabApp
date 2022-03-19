package com.example.onlabapp.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlabapp.MainActivity
import com.example.onlabapp.R
import com.example.onlabapp.adapter.ProductsAdapter
import com.example.onlabapp.data.Product
import com.example.onlabapp.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val inflated = inflater.inflate(R.layout.fragment_products, container, false)

        val products= arrayListOf<Product>()
        for(i in 0..5){
            products.add(Product("", "https://via.placeholder.com/150", 2.0))
            println(i)
        }

        recyclerView= inflated.findViewById(R.id.recycler_View)

        recyclerView.apply {
            layoutManager= GridLayoutManager(context, 2)
            adapter = ProductsAdapter(products)
        }



        return inflated
    }



}