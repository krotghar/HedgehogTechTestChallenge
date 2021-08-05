package com.example.hedgehogtechtestchallenge.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Joke(
    @SerialName("type")
    val type : String,
    @SerialName("value")
    val value : Value
)
@Serializable
data class Value(
    @SerialName("id")
    val id : Int,
    @SerialName("joke")
    val joke : String
)

