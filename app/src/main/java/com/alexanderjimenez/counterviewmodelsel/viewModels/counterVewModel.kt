package com.alexanderjimenez.counterviewmodelsel.viewModels

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class counterVewModel : ViewModel() {
    private val _counter = mutableIntStateOf(0)
    val counter = _counter

    fun add(){
        _counter.intValue++
    }
}