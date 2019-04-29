package com.example.ShoppingCartKotlin.resolver


import com.example.ShoppingCartKotlin.repository.ProductRepository

import com.coxautodev.graphql.tools.GraphQLMutationResolver

import org.springframework.stereotype.Component
import java.util.*

import com.example.ShoppingCartKotlin.entity.Product

@Component
class ProductMutationResolver(private val productRepository: ProductRepository): GraphQLMutationResolver {

    fun newProduct(vendorId: String,name: String, price: Int,  description: String = ""): Product {
        var product = Product(vendorId, name, price, description)
        product.id = UUID.randomUUID().toString()
        productRepository.save(product)
        return product
    }
}