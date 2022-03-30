package com.eugene_dolgushev.contact.contactList.di

import com.eugene_dolgushev.TemporaryDatabase
import com.eugene_dolgushev.contact.contactList.data.ContactRepositoryImpl
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.contactList.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.contact.data.Contact

object ContactListDICompanion {

    val addContactUseCase: AddContactUseCase by lazy {
        AddContactUseCase(mContactRepository)
    }
    val getContactListUseCase: GetContactListUseCase by lazy {
        GetContactListUseCase(mContactRepository)
    }
    val deleteContactUseCase: DeleteContactUseCase by lazy {
        DeleteContactUseCase(mContactRepository)
    }

    private lateinit var mContactRepository: IContactRepository<Contact>

    fun init() {
        mContactRepository = ContactRepositoryImpl(TemporaryDatabase)
    }
}