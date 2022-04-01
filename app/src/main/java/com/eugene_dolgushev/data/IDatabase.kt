package com.eugene_dolgushev.data

import androidx.lifecycle.LiveData

interface IDatabase<T> {

    val data: LiveData<List<T>>

    fun add(item: T)

    fun remove(item: T)
}