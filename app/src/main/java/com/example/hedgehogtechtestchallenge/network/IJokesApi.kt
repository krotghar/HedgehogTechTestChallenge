package com.example.hedgehogtechtestchallenge.network

import com.example.hedgehogtechtestchallenge.data.JokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IJokesApi {

    @GET("jokes/random/{number}")
    suspend fun getJokes(
        @Path("number") number: Int?
    ) : Response<JokeResponse>
}