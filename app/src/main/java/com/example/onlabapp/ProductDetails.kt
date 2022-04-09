package com.example.onlabapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlabapp.adapter.ProductsAdapter
import com.example.onlabapp.databinding.ProductDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails: AppCompatActivity() {

    private lateinit var binding:ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        binding=ProductDetailsBinding.inflate(layoutInflater)

        val title=intent.getStringExtra("title")
        val photoUrl=intent.getStringExtra("photoUrl")
        val price=intent.getStringExtra("price")


        product_name.text=title
        product_price.text=price
        Picasso.get().load(photoUrl).into(product_image)

    }
}