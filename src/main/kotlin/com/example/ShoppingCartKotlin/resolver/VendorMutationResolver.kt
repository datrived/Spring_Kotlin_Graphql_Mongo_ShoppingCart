package com.example.ShoppingCartKotlin.resolver

import com.example.ShoppingCartKotlin.entity.Vendor


import com.example.ShoppingCartKotlin.repository.VendorRepository

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component
import java.util.*

@Component
class VendorMutationResolver(private val vendorRepository: VendorRepository): GraphQLMutationResolver{

    fun newVendor(name: String): Vendor{
        val vendor = Vendor(name)
        vendor.id = UUID.randomUUID().toString()
        vendorRepository.save(vendor)
        return vendor
    }

    fun deleteVendor(id: String): Boolean{
        vendorRepository.deleteById(id)
        return true
    }

    fun updateVendor(id: String, name: String): Vendor{
        var vendor = vendorRepository.findById(id)
        vendor.ifPresent({
            it.name = name
            vendorRepository.save(it)
        })

        return vendor.get()


    }



}