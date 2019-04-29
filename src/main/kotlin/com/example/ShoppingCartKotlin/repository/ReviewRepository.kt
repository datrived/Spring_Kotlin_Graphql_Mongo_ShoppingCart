package com.example.ShoppingCartKotlin.repository
import com.example.ShoppingCartKotlin.entity.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: MongoRepository<Review, String>