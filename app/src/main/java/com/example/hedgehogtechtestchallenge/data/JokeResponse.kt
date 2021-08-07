package com.example.hedgehogtechtestchallenge.data

import com.google.gson.annotations.SerializedName


data class JokeResponse(
    @SerializedName("type")
    val type : String,
    @SerializedName("value")
    val values : List<Joke>
)
data class Joke(
    @SerializedName("id")
    val id : Int,
    @SerializedName("joke")
    val joke : String,
    @SerializedName("categories")
    val categories: List<String>
)

