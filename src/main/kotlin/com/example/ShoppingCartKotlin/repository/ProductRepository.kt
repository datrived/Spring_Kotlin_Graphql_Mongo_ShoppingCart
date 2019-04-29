
package com.example.ShoppingCartKotlin.repository


import com.example.ShoppingCartKotlin.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: MongoRepository<Product, String>