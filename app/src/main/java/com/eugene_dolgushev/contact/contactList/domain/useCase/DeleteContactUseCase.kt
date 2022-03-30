package com.eugene_dolgushev.contact.contactList.domain.useCase

import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.data.Contact

class DeleteContactUseCase(
    private val contactRepository: IContactRepository<Contact>
) {

    fun execute(contact: Contact) {
        contactRepository.deleteContact(contact)
    }
}