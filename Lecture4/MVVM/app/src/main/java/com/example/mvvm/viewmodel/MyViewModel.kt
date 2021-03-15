package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.repo.JokeRepository

class MyViewModel : ViewModel() {
        private val jokeRepository: JokeRepository = JokeRepository();
        private val joke = MutableLiveData<Joke>()


        fun getJokes(): LiveData<Joke> {
            return joke;
        }

        fun loadJokes() {
            joke.value = jokeRepository.fetchRandomJoke()
        }
}

//This is the model
data class Joke(val text: String) {
}
