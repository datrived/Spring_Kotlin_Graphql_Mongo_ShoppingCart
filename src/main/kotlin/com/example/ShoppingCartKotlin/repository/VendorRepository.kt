package com.example.ShoppingCartKotlin.repository

import com.example.ShoppingCartKotlin.entity.Vendor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface VendorRepository: MongoRepository<Vendor, String>