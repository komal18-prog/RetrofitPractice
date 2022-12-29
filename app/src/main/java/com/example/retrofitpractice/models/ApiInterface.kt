package com.example.retrofitpractice.models

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users?page=2")
     fun getAllUsers(): Response<ResponseListUsers>
}