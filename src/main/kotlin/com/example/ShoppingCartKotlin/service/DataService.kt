package com.example.ShoppingCartKotlin.service


import com.example.ShoppingCartKotlin.resolver.*

import com.example.ShoppingCartKotlin.entity.Vendor
import com.example.ShoppingCartKotlin.entity.Review
import com.example.ShoppingCartKotlin.entity.Product

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface DataService{
    fun getAllVendors(): List<Vendor>
    fun deleteVendor(id: String): Boolean
    fun createVendor(name: String): Vendor
    fun updateVendor(id: String, name: String): Vendor
    fun getVendorById(id: String): Vendor


    fun getProductsByVendor(vendorId: String): List<Product>
    fun getReviewsForProduct(productId: String): List<Review>
}


@Service("dataService")
class DataServiceImpl: DataService{

    @Autowired
    lateinit var vendorQueryResolver: VendorQueryResolver

    @Autowired
    lateinit var vendorMutationResolver: VendorMutationResolver

    @Autowired
    lateinit var productQueryResolver: ProductQueryResolver

    @Autowired
    lateinit var reviewQueryResolver: ReviewQueryResolver

    @Override
    override fun getAllVendors(): List<Vendor>{
        return vendorQueryResolver.vendors()
    }

    @Override
    override fun deleteVendor(id: String): Boolean{
        return vendorMutationResolver.deleteVendor(id)
    }

    @Override
    override fun createVendor(name: String): Vendor{
        return vendorMutationResolver.newVendor(name)
    }

    @Override
    override fun updateVendor(id: String, name: String): Vendor{
        return vendorMutationResolver.updateVendor(id, name)
    }

    @Override
    override fun getVendorById(id: String): Vendor{
        return vendorQueryResolver.vendor(id)
    }

    @Override
    override fun getProductsByVendor(vendorId: String): List<Product>{
        return productQueryResolver.products(vendorId)
    }

    @Override
    override fun getReviewsForProduct(productId: String): List<Review>{
        return reviewQueryResolver.reviews(productId)
    }

}
