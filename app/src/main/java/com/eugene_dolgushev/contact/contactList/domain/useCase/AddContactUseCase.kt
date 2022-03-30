package com.eugene_dolgushev.contact.contactList.domain.useCase

import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.contactList.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactList.domain.models.Result

class AddContactUseCase(
    private val contactRepository: IContactRepository<Contact>
) {

    fun execute(params: AddContactParams) = when {
        params.name.isEmpty() -> {
            Result.Error("Пустое имя")
        }
        !isPhoneValid(params.phone) -> {
            Result.Error("Пустой номер телефона")
        }
        else -> {
            contactRepository.addContact(Contact(name = params.name, phone = params.phone))
            Result.Success
        }
    }

    private fun isPhoneValid(phone: String): Boolean {
        return true
    }
}