package com.example.founderapp.base.Response

import com.google.gson.annotations.SerializedName

class ResponseClass {
    data class LoginResponse(
        @SerializedName("token") val token: String
    )
}