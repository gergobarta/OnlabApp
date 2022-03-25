package com.example.onlabapp.fragments

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment : Fragment() {

    val db = Firebase.firestore
    private lateinit var binding: FragmentProductsBinding
    private lateinit var adapter: ProductsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentProductsBinding.inflate(inflater, container, false)

        adapter= ProductsAdapter()

        binding.recyclerView.adapter=adapter

//////////////////////6
        db.collection("shopItems")
            .get()
            .addOnSuccessListener {
                    result ->
                var result2= result.filter {
                    it.data["category"]!=null
                }
                for (document in result2) {

                    adapter.addProduct(Product( document.data["name"].toString(), document.data["pictureUrl"].toString()  , document.data["price"].toString()?.toDouble()))
                    //Log.d(TAG, "${document.id} => ${document.data}")
                   // println(document.data["price"].toString())
                    //println(products.last().title)
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }


        //////////////////////6


/////////////////////////6

      //  adapter.addProduct(Product("test", "https://via.placeholder.com/150", 2.0))


        binding.recyclerView.layoutManager= GridLayoutManager(context, 2)
       /* recyclerView= inflated.findViewById(R.id.recycler_View)

        recyclerView.apply {
            layoutManager= GridLayoutManager(context, 2)
            adapter = ProductsAdapter(products)
        }
*/


        return binding.root
    }



}