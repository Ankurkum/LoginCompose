package com.example.newloginappcomp.data.models

import com.example.newloginappcomp.data.models.Address
import com.example.newloginappcomp.data.models.Company

data class UserResponseItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)