package com.eugene_dolgushev.contact.contactList.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eugene_dolgushev.contact.data.Contact
import com.eugene_dolgushev.contact.contactList.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactList.domain.models.Result
import com.eugene_dolgushev.contact.contactList.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase

class ContactListViewModel(
    private val addContactUseCase: AddContactUseCase,
    private val getContactListUseCase: GetContactListUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
) : ViewModel() {

    val contactList: LiveData<List<Contact>>
        get() = mutableContactList

    private lateinit var mutableContactList: LiveData<List<Contact>>

    init {
        loadList()
    }

    fun loadList() {
        mutableContactList = getContactListUseCase.execute()
    }

    fun addContact(params: AddContactParams, callback: (result: Result) -> Unit) {
        callback(addContactUseCase.execute(params))
    }

    fun deleteContact(contact: Contact) {
        deleteContactUseCase.execute(contact)
    }
}