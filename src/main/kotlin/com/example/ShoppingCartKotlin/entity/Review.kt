package com.example.ShoppingCartKotlin.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "review")
data class Review(var productId: String, var rating: Int,var reviewDesc: String="",var by: String = ""){
    @Id
    var id: String = ""
}