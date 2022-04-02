package com.eugene_dolgushev.di

import com.eugene_dolgushev.contact.contactAdd.di.ContactAddDICompanion
import com.eugene_dolgushev.contact.contactList.data.ContactRepositoryImpl
import com.eugene_dolgushev.contact.contactList.di.ContactListDICompanion
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.data.TemporaryDatabase

object ApplicationDICompanion {

    private val mContactRepository: IContactRepository<Contact> by lazy {
        ContactRepositoryImpl(TemporaryDatabase)
    }

    fun init() {
        ContactListDICompanion.init(contactRepository = mContactRepository)
        ContactAddDICompanion.init(contactRepository = mContactRepository)
    }
}