package com.example.newloginappcomp.data.remote

import com.example.newloginappcomp.data.models.UserResponseItem

class UserListRepository(private val iApiInterface: IApiInterface) {

    suspend fun getUserData(): List<UserResponseItem>{
        val response = iApiInterface.getUserData()
        if(response.isSuccessful){
            return response.body()!!
        }
        return emptyList()
    }
}