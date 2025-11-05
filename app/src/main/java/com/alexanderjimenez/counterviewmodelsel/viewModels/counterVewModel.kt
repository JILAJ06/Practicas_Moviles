package com.alexanderjimenez.counterviewmodelsel.viewModels

import androidx.compose.runtime.mutableIntStateOf


class counterVewModel() {
    private val _counter = mutableIntStateOf(0)
    val counter = _counter

    fun add(){
        _counter.intValue++
    }

}