package com.example.ShoppingCartKotlin.resolver

import com.example.ShoppingCartKotlin.entity.Review

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ReviewQueryResolver(val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    fun reviews(productId: String): List<Review> {
        var query = Query()
        query.addCriteria(Criteria.where("productId").`is`(productId))
        return mongoOperations.find(query, Review::class.java)
    }
}