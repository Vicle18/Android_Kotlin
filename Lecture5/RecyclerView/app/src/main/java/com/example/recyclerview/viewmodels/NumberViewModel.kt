package com.example.recyclerview.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList


class NumberViewModel : ViewModel() {
    private val numbers = MutableLiveData<ArrayList<Number>>();
    private val listOfNumbers = ArrayList<Number>();
    private val randomNumber = Random();


    init {
        insertNumbers(100);
        numbers.value = listOfNumbers;
    }

    private fun insertNumbers(amountOfNumbers : Int) {
        for (i in 0 until amountOfNumbers) {
            listOfNumbers.add((randomNumber.nextInt(10000)))

            //while(amountOfNumbers != 0 && amountOfNumbers != listOfNumbers.size){
            //    listOfNumbers.add(randomNumber.nextInt(100));
            //    Log.i("Tag", "insertNumbers loop")
            //}
        }
    }

        fun getNumbers(): MutableLiveData<ArrayList<Number>> {
            return numbers;
        }

}