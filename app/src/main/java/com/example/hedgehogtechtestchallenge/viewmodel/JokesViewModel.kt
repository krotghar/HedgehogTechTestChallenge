package com.example.hedgehogtechtestchallenge.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.hedgehogtechtestchallenge.data.Joke
import com.example.hedgehogtechtestchallenge.network.JokeService
import kotlinx.coroutines.*


class JokesViewModel : ViewModel() {
    private val jokeService = JokeService().getJokeService()
    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        ErrorResult("ExceptionHandled: ${throwable.localizedMessage}")
    }
    private  val jokeCount = MutableLiveData<Int>()
    val jokes = MutableLiveData<List<Joke>>()
    private val loadError = MutableLiveData<String?>()
    private val loading = MutableLiveData<Boolean>()

    fun refresh(number: Int) {
        jokeCount.value = number
        fetchJokes()
    }

    private fun fetchJokes() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = jokeService.getJokes(jokeCount.value)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful){
                    Log.d(JokesViewModel::class.java.simpleName, "Response Success")
                    jokes.value = response.body()?.values
                    loading.value = false
                } else {
                    onError("Message: ${response.message()}")
                }

            }
        }
        loading.value = false

    }

    private fun onError(string: String) {
        loadError.value = string
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
 }

