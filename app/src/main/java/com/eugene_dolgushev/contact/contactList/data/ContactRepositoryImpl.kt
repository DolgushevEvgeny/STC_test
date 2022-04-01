package com.eugene_dolgushev.contact.contactList.data

import com.eugene_dolgushev.data.IDatabase
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.data.Contact

class ContactRepositoryImpl(private val database: IDatabase<Contact>) :
    IContactRepository<Contact> {

    override fun addContact(contact: Contact) {
        database.add(contact)
    }

    override fun deleteContact(contact: Contact) {
        database.remove(contact)
    }

    override fun getContactLiveData() = database.data

    override fun getContactList() = database.data.value ?: emptyList()
}