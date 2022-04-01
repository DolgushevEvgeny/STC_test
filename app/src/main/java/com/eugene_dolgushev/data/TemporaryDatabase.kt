package com.eugene_dolgushev.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eugene_dolgushev.contact.data.Contact

object TemporaryDatabase : IDatabase<Contact> {

    override val data: LiveData<List<Contact>>
        get() = mMutableContactList

    private val mMutableContactList: MutableLiveData<List<Contact>>

    init {
        val list = mutableListOf<Contact>()
        list.add(Contact("1", "+79999999999"))
        list.add(Contact("2", "+79999999998"))
        list.add(Contact("3", "+79999999997"))
        list.add(Contact("4", "+79999999996"))
        list.add(Contact("5", "+79999999995"))

        mMutableContactList = MutableLiveData()
        mMutableContactList.value = list
    }

    override fun add(item: Contact) {
        val list = mutableListOf<Contact>()
        list.addAll(mMutableContactList.value ?: emptyList())
        list.add(item)
        mMutableContactList.value = list
    }

    override fun remove(item: Contact) {
        val list = mutableListOf<Contact>()
        list.addAll(mMutableContactList.value ?: emptyList())
        list.remove(item)
        mMutableContactList.value = list
    }
}