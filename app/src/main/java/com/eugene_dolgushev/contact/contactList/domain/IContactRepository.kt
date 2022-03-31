package com.eugene_dolgushev.contact.contactList.domain

import androidx.lifecycle.LiveData

interface IContactRepository<T> {

    fun addContact(contact: T)

    fun deleteContact(contact: T)

    fun getContactLiveData(): LiveData<List<T>>

    fun getContactList(): List<T>
}