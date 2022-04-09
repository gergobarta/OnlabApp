package com.example.onlabapp.data

import java.io.Serializable

data class Product(

    val title: String,
    val photoUrl: String,
    val price: Double
): Serializable
