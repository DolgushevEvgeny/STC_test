package com.eugene_dolgushev.contact.contactList.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eugene_dolgushev.contact.contactAdd.domain.models.AddContactParams
import com.eugene_dolgushev.contact.contactAdd.domain.models.Result
import com.eugene_dolgushev.contact.contactAdd.domain.useCase.AddContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.DeleteContactUseCase
import com.eugene_dolgushev.contact.contactList.domain.useCase.GetContactListUseCase
import com.eugene_dolgushev.contact.data.Contact

class ContactListViewModel(
    private val getContactListUseCase: GetContactListUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
) : ViewModel() {

    val contactList: LiveData<List<Contact>>
        get() = mContactList
    val deleteContactEvent: LiveData<Contact?>
        get() = mDeleteContactEvent

    private lateinit var mContactList: LiveData<List<Contact>>
    private val mDeleteContactEvent: MutableLiveData<Contact?> = MutableLiveData(null)

    init {
        loadList()
    }

    fun showContactDeleteDialog(contact: Contact?) {
        mDeleteContactEvent.value = contact
    }

    fun deleteContact(contact: Contact) {
        cancelDeleteContact()
        deleteContactUseCase.execute(contact)
    }

    fun cancelDeleteContact() {
        mDeleteContactEvent.value = null
    }

    private fun loadList() {
        mContactList = getContactListUseCase.execute()
    }
}