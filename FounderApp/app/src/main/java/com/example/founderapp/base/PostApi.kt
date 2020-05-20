package com.example.founderapp.base


import com.example.founderapp.model.Post
import com.example.founderapp.model.UserLoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface PostApi {

    @GET("posts")
    fun getPosts(): Observable<List<Post>>

    @FormUrlEncoded
    @POST("login")
    fun doLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Observable<UserLoginResponse>
}