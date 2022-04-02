package com.eugene_dolgushev.contact.contactAdd.domain.useCase

import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactAdd.domain.models.Result
import com.eugene_dolgushev.contact.contactList.domain.IContactRepository
import com.eugene_dolgushev.contact.data.Contact
import java.util.regex.Pattern

class AddContactUseCase(
    private val contactRepository: IContactRepository<Contact>
) {

    fun execute(params: AddContactParams) = when {
        params.name.isEmpty() -> {
            Result.Error("Пустое имя")
        }
        params.phone.isEmpty() -> {
            Result.Error("Пустой номер телефона")
        }
        !isPhoneValid(params.phone) -> {
            Result.Error("Неправильный номер телефона")
        }
        isContactExisted(params.phone) -> {
            Result.Error("Такой номер телефона уже существует")
        }
        else -> {
            contactRepository.addContact(Contact(name = params.name, phone = params.phone))
            Result.Success
        }
    }

    private fun isContactExisted(phone: String): Boolean {
        val contacts = contactRepository.getContactList()
        val existedContact = contacts.find { it.phone == phone }
        return existedContact != null
    }

    private fun isPhoneValid(phone: String): Boolean {
        return Pattern.compile(PHONE_PATTERN).matcher(phone).matches()
    }

    companion object {
        private const val PHONE_PATTERN = "^(\\+7)?[0-9]{10}\$"
    }
}