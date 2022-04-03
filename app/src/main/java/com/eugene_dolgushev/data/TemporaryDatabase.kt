package com.eugene_dolgushev.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eugene_dolgushev.contact.data.Contact

object TemporaryDatabase : IDatabase<Contact> {

    override val data: LiveData<List<Contact>>
        get() = mMutableContactList

    private val mMutableContactList: MutableLiveData<List<Contact>> = MutableLiveData()

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