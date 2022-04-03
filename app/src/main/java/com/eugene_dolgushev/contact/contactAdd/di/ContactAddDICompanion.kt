package com.eugene_dolgushev.contact.contactAdd.di

import com.eugene_dolgushev.contact.contactAdd.domain.models.ContactPhoneValidator
import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.data.Contact

object ContactAddDICompanion {

    val addContactUseCase: AddContactUseCase by lazy {
        AddContactUseCase(mContactRepository, mContactPhoneValidator)
    }
    private val mContactPhoneValidator by lazy {
        ContactPhoneValidator()
    }

    private lateinit var mContactRepository: IContactRepository<Contact>

    fun init(
        contactRepository: IContactRepository<Contact>
    ) {
        mContactRepository = contactRepository
    }
}