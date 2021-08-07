package com.example.hedgehogtechtestchallenge.viewmodel

import com.example.hedgehogtechtestchallenge.data.Joke

sealed class JokesResult
class ValidResult(val result: List<Joke>) : JokesResult()
class ErrorResult(val e: String) : JokesResult()
