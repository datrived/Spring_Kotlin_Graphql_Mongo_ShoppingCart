package com.example.ShoppingCartKotlin.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "vendor")
data class Vendor(var name : String){
    @Id
    var id: String = ""

    @Transient
    var products: List<Product> = ArrayList<Product>()
}
