package com.example.first

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
const val BASEURL="https://jsonplaceolder.typicode-com"

interface MyAPI {

    @GET("/comments")
    suspend fun getComments(): Response<List<Comments>>

}