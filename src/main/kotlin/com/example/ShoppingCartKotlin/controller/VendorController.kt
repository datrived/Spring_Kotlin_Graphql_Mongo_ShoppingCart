package com.example.ShoppingCartKotlin.controller

import com.example.ShoppingCartKotlin.service.*
import com.example.ShoppingCartKotlin.entity.Vendor
import com.example.ShoppingCartKotlin.entity.Review
import com.example.ShoppingCartKotlin.entity.Product

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import kotlin.streams.toList
import org.springframework.http.MediaType

@RestController
@RequestMapping("/api/vendor")
class VendorController(){

    @Autowired lateinit var dataServiceImpl: DataServiceImpl

    @RequestMapping(value = ["/all"], method = [RequestMethod.GET])
    fun getVendors():List<Vendor>{
        return dataServiceImpl.getAllVendors()
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    fun getVendorById(@PathVariable id: String):Vendor{
        return dataServiceImpl.getVendorById(id)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteVendor(@PathVariable id: String): Boolean{
        return dataServiceImpl.deleteVendor(id)
    }

    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
    fun newVendor(@RequestBody v: Vendor): Vendor{
        return dataServiceImpl.createVendor(v.name)
    }


    @RequestMapping(value = ["/{id}"], method = [RequestMethod.PUT])
    fun updateVendor(@PathVariable id: String, @RequestBody v: Vendor): Vendor{
        return dataServiceImpl.updateVendor(id, v.name)
    }

}


