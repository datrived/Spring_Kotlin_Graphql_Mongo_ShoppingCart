package com.example.ShoppingCartKotlin.resolver

import com.example.ShoppingCartKotlin.entity.Vendor
import com.example.ShoppingCartKotlin.entity.Review
import com.example.ShoppingCartKotlin.entity.Product

import com.example.ShoppingCartKotlin.repository.VendorRepository

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class VendorQueryResolver(val vendorRepository: VendorRepository, private val monogoOperations: MongoOperations): GraphQLQueryResolver{

    fun vendors(): List<Vendor>{

        val vendorList = vendorRepository.findAll()

        vendorList.forEach { item ->
            item.products = getProducts(vendorId = item.id)

                for(it in item.products) {
                    it.reviews = getReviews(productId = it.id)
                }
        }

        return vendorList
    }

    fun vendor(vendorId: String): Vendor{
        var vendor = vendorRepository.findById(vendorId).get()

        vendor.products = getProducts(vendorId = vendor.id)


        for(it in vendor.products) {
            it.reviews = getReviews(productId = it.id)
        }

        return vendor

    }

    private fun getReviews(productId : String): List<Review>{
        val query = Query()
        query.addCriteria(Criteria.where("productId").`is`(productId))
        return monogoOperations.find(query, Review::class.java)
    }

    private fun getProducts(vendorId: String): List<Product>{
        val query = Query()
        query.addCriteria(Criteria.where("vendorId").`is`(vendorId))
        return monogoOperations.find(query, Product::class.java)
    }
}