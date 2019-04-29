package com.example.ShoppingCartKotlin.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "Product")
data class Product(var vendorId: String, var name: String, var price: Int, var description: String=""){

    @Id
    var id: String = ""


    @Transient
    var reviews: List<Review> = ArrayList<Review>()

}