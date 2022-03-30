package com.eugene_dolgushev.contact.contactList.domain.useCase

import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository

class GetContactListUseCase(
    private val contactRepository: IContactRepository<Contact>
) {

    fun execute() = contactRepository.getContactList()
}