package com.example.ShoppingCartKotlin.resolver

import com.example.ShoppingCartKotlin.repository.ReviewRepository

import com.coxautodev.graphql.tools.GraphQLMutationResolver

import org.springframework.stereotype.Component


import com.example.ShoppingCartKotlin.entity.Review
import java.util.*
@Component
class ReviewMutationResolver (private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(productId: String, rating: Int, reviewDesc: String="", by: String = ""): Review{
        var review = Review(productId, rating, reviewDesc, by)
        review.id = UUID.randomUUID().toString()
        reviewRepository.save(review)
        return review
    }
}