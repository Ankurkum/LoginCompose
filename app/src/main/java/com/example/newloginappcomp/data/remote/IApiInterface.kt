package com.example.newloginappcomp.data.remote

import com.example.newloginappcomp.data.models.UserResponseItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IApiInterface {

    @GET("/users")
    suspend fun getUserData(): Response<List<UserResponseItem>>


    companion object {
        fun getAPiInterface(): IApiInterface {
            return Retrofit.Builder().
            baseUrl("https://jsonplaceholder.typicode.com").
            addConverterFactory(GsonConverterFactory.create())
                .build().create(IApiInterface::class.java)
        }
    }

}