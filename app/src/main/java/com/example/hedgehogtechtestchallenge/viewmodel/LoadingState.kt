package com.example.hedgehogtechtestchallenge.viewmodel

sealed class LoadingState
object Loading : LoadingState()
object Ready : LoadingState()
