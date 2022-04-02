package com.eugene_dolgushev.contact.contactList.di

import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.contact.data.Contact

object ContactListDICompanion {

    val getContactListUseCase: GetContactListUseCase by lazy {
        GetContactListUseCase(mContactRepository)
    }
    val deleteContactUseCase: DeleteContactUseCase by lazy {
        DeleteContactUseCase(mContactRepository)
    }

    private lateinit var mContactRepository: IContactRepository<Contact>

    fun init(
        contactRepository: IContactRepository<Contact>
    ) {
        mContactRepository = contactRepository
    }
}