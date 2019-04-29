package com.example.ShoppingCartKotlin.resolver

import com.example.ShoppingCartKotlin.entity.Product
import com.example.ShoppingCartKotlin.entity.Review
import com.example.ShoppingCartKotlin.repository.ProductRepository

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun products(vendorId: String): List<Product>{
        var query = Query()
        query.addCriteria(Criteria.where("vendorId").`is`(vendorId))
        var result = mongoOperations.find(query, Product::class.java)

        for(item in result){
            item.reviews = getReviews(productId = item.id)
        }

        return result
    }

    private fun getReviews(productId : String): List<Review>{
        val query = Query()
        query.addCriteria(Criteria.where("productId").`is`(productId))
        return mongoOperations.find(query, Review::class.java)
    }
}