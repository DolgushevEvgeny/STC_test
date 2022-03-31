package com.eugene_dolgushev.contact.contactAdd.presentation

import androidx.lifecycle.ViewModel
import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactAdd.domain.models.Result
import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase

class ContactAddViewModel(
    private val addContactUseCase: AddContactUseCase,
    private val getContactListUseCase: GetContactListUseCase
) : ViewModel() {

    init {

    }

    fun addContact(params: AddContactParams, callback: (result: Result) -> Unit) {
        callback(addContactUseCase.execute(params))
    }
}